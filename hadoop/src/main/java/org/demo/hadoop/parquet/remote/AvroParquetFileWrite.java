package org.demo.hadoop.parquet.remote;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.security.UserGroupInformation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;

import parquet.avro.AvroParquetWriter;
import parquet.hadoop.ParquetWriter;
import parquet.hadoop.metadata.CompressionCodecName;

public class AvroParquetFileWrite {
    private static final Logger LOG = LoggerFactory.getLogger(AvroParquetFileWrite.class);
    private static String SCHEMA = "EmpSchema.avsc";
    private static String PARQUET_FILE = "hdfs://fhc/tmp/000000_1";
    private static String KERB_REALM;
    private static String KERB_FILE;
    private static String KERB_CONF;

    static {
        if (System.getProperty("os.name").toLowerCase().startsWith("win")) {
            System.setProperty("hadoop.home.dir", "E:\\hadoop\\winutils\\hadoop-2.6.0");

            KERB_REALM = "arch_onedata@OD.BETA";
            KERB_FILE = "D:\\kerberos\\arch_onedata.keytab.beta";
            KERB_CONF = "D:\\kerberos\\krb5-beta.conf";
        } else {
            KERB_REALM = "arch_onedata@OD.BETA";
            KERB_FILE = "/home/hadoop/code/temp/arch_onedata.keytab";
            KERB_CONF = "/etc/krb5.conf";
        }
    }

    public static void main(String[] args) {
        if (args.length > 0) {
            PARQUET_FILE = args[0];
        }

        // First thing - parse the schema as it will be used
        System.out.println("main(): ");

        Schema schema = parseSchema();
        List<GenericData.Record> recordList = getRecords(schema);
        writeToParquet(recordList, schema);
    }

    private static Schema parseSchema() {
        System.out.println("parseSchema()");
        Schema.Parser parser = new Schema.Parser();
        Schema schema = null;
        try {
            // pass path to schema
            InputStream is = ClassLoader.getSystemResourceAsStream(SCHEMA);
            schema = parser.parse(is);
        } catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Exception");
            e.printStackTrace();
        }
        System.out.println("parseSchema(): " + schema.toString());
        return schema;
    }

    private static List<GenericData.Record> getRecords(Schema schema) {
        System.out.println("getRecords()");
        List<GenericData.Record> recordList = new ArrayList<GenericData.Record>();
        GenericData.Record record = new GenericData.Record(schema);
        // Adding 2 records
        record.put("id", 1);
        record.put("Name", "emp1");
        record.put("Dept", "D1");
        recordList.add(record);

        record = new GenericData.Record(schema);
        record.put("id", 2);
        record.put("Name", "emp2");
        record.put("Dept", "D2");
        recordList.add(record);

        System.out.println("getRecords(): " + recordList.toString());
        return recordList;
    }

    private static void writeToParquet(List<GenericData.Record> recordList, Schema schema) {
        System.out.println("writeToParquet()");
        // Path to Parquet file in HDFS
        Path path = new Path(PARQUET_FILE);
        ParquetWriter<GenericData.Record> writer = null;

        // Creating ParquetWriter using builder
        try {
            Configuration conf = new Configuration();

            LOG.info("conf.set()");

            conf.set("fs.hdfs.impl", org.apache.hadoop.hdfs.DistributedFileSystem.class.getName());
            conf.set("fs.file.impl", org.apache.hadoop.fs.LocalFileSystem.class.getName());
            conf.set("fs.webhdfs.impl", org.apache.hadoop.hdfs.web.WebHdfsFileSystem.class.getName());

            // conf.set("dfs.namenode.kerberos.principal","hdfs/_HOST@OD.BETA");
            // conf.set("dfs.datanode.kerberos.principal","hdfs/_HOST@OD.BETA");

            conf.set("hadoop.security.authentication", "kerberos");
            conf.set("hadoop.security.authorization", "true");

            System.setProperty("java.security.krb5.conf", KERB_CONF);

            LOG.info("UserGroupInformation.setConfiguration()");
            UserGroupInformation.setConfiguration(conf);
            LOG.info("UserGroupInformation.loginUserFromKeytab()");
            UserGroupInformation.loginUserFromKeytab(KERB_REALM, KERB_FILE);
            LOG.info("UserGroupInformation.getLoginUser()");
            UserGroupInformation.getLoginUser();

            conf.set("dfs.client.failover.proxy.provider.fhc", "org.apache.hadoop.hdfs.server.namenode.ha.ConfiguredFailoverProxyProvider");
            conf.set("dfs.ha.namenodes.fhc", "nn1,nn2");
            conf.set("dfs.namenode.rpc-address.fhc.nn1", "arch-od-data01.beta1.fn:8020");
            conf.set("dfs.namenode.rpc-address.fhc.nn2", "arch-od-data02.beta1.fn:8020");
            conf.set("dfs.nameservices", "fhc");

            writer = AvroParquetWriter.
                    <GenericData.Record>builder(path)
                    .withRowGroupSize(ParquetWriter.DEFAULT_BLOCK_SIZE)
                    .withPageSize(ParquetWriter.DEFAULT_PAGE_SIZE)
                    .withSchema(schema)
                    .withConf(conf)
                    .withCompressionCodec(CompressionCodecName.SNAPPY)
                    .withValidation(false)
                    .withDictionaryEncoding(false)
                    .build();

            for (GenericData.Record record : recordList) {
                writer.write(record);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
