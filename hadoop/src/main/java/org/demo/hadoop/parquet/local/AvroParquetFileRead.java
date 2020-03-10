package org.demo.hadoop.parquet.local;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.avro.generic.GenericData;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import parquet.avro.AvroParquetReader;
import parquet.hadoop.ParquetReader;

public class AvroParquetFileRead {
    private static final Logger LOG = LoggerFactory.getLogger(AvroParquetFileRead.class);
    private static String PARQUET_FILE;

    static {
        if (System.getProperty("os.name").toLowerCase().startsWith("win")) {
            System.setProperty("hadoop.home.dir", "E:\\hadoop\\winutils\\hadoop-2.6.0");
            PARQUET_FILE = "E:\\temp\\000000_0";
        } else {
            PARQUET_FILE = "/home/hadoop/code/temp/000000_0";
        }
    }

    public static void main(String[] args) {
        if (args.length > 0) {
            PARQUET_FILE = args[0];
        }

        readParquetFile();
    }

    private static void readParquetFile() {
        ParquetReader<GenericData.Record> reader = null;
        Path path = new Path(PARQUET_FILE);
        try {
            Configuration configuration = new Configuration();
            //configuration.set("fs.hdfs.impl",org.apache.hadoop.hdfs.DistributedFileSystem.class.getName());
            //configuration.set("fs.file.impl",org.apache.hadoop.fs.LocalFileSystem.class.getName());

            reader = AvroParquetReader
                    .<GenericData.Record>builder(path)
                    .withConf(configuration)
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
