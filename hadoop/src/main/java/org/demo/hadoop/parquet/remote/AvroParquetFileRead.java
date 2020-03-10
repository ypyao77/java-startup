package org.demo.hadoop.parquet.remote;

import org.apache.avro.generic.GenericData;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.security.UserGroupInformation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import parquet.avro.AvroParquetReader;
import parquet.hadoop.ParquetReader;

import java.io.IOException;

public class AvroParquetFileRead {
    private static final Logger LOG = LoggerFactory.getLogger(AvroParquetFileRead.class);

    //private static String PARQUET_FILE = "E:\\temp\\000000_0";
    private static String PARQUET_FILE = "hdfs://fhc/tmp/000000_0";
    private static String KERB_REALM;
    private static String KERB_FILE;
    private static String KERB_CONF;

    private static String HADOOP_HOME_DIR = "E:\\hadoop\\winutils\\hadoop-2.6.0";

    static {
        if (System.getProperty("os.name").toLowerCase().startsWith("win")) {
            System.setProperty("hadoop.home.dir", HADOOP_HOME_DIR);

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
        readParquetFile();
    }

    private static void readParquetFile() {
        LOG.info("readParquetFile()");

        ParquetReader<GenericData.Record> reader = null;
        Path path = new Path(PARQUET_FILE);

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

            reader = AvroParquetReader
                    .<GenericData.Record>builder(path)
                    .withConf(conf)
                    .build();
            GenericData.Record record;
            while ((record = reader.read()) != null) {
                System.out.println(record);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
}
