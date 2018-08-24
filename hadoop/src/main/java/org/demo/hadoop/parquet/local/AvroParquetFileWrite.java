package org.demo.hadoop.parquet.local;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

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
    private static String PARQUET_FILE;

    static {
        if (System.getProperty("os.name").toLowerCase().startsWith("win")) {
            System.setProperty("hadoop.home.dir", "E:\\hadoop\\winutils\\hadoop-2.6.0");
            PARQUET_FILE = "E:\\temp\\emp.parquet";
        } else {
            PARQUET_FILE = "/home/hadoop/code/temp/emp.parquet";
        }
    }

    public static void main(String[] args) {
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
            Configuration configuration = new Configuration();
            // configuration.set("fs.hdfs.impl",org.apache.hadoop.hdfs.DistributedFileSystem.class.getName());
            // configuration.set("fs.file.impl",org.apache.hadoop.fs.LocalFileSystem.class.getName());

            writer = AvroParquetWriter.
                    <GenericData.Record>builder(path)
                    .withRowGroupSize(ParquetWriter.DEFAULT_BLOCK_SIZE)
                    .withPageSize(ParquetWriter.DEFAULT_PAGE_SIZE)
                    .withSchema(schema)
                    .withConf(configuration)
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
