package com.xiewendomg.admin.bigdata.hive;

import com.alibaba.fastjson.JSON;
import com.xiewendomg.admin.bigdata.User;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hive.ql.io.orc.OrcOutputFormat;
import org.apache.hadoop.hive.ql.io.orc.OrcSerde;
import org.apache.hadoop.hive.serde2.DelimitedJSONSerDe;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspectorFactory;
import org.apache.hadoop.hive.serde2.objectinspector.StructObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.primitive.JavaStringObjectInspector;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.OutputFormat;
import org.apache.hadoop.mapred.RecordWriter;
import org.apache.hadoop.mapred.Reporter;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestOrcWrite {
    public static void main(String[] args) throws Exception {
        JobConf conf = new JobConf();
        FileSystem fs = FileSystem.get(conf);
        Path outputPath = new Path("D:\\user.orc");
        StructObjectInspector inspector =
                (StructObjectInspector) ObjectInspectorFactory
                        .getReflectionObjectInspector(User.class,
                                ObjectInspectorFactory.ObjectInspectorOptions.JAVA);
        OrcSerde serde = new OrcSerde();
        OutputFormat outFormat = new OrcOutputFormat();
        RecordWriter writer = outFormat.getRecordWriter( fs, conf,
                outputPath.toString(), Reporter.NULL);
        writer.write(NullWritable.get(), serde.serialize(new User(24,"小红红",5), inspector));
        writer.write(NullWritable.get(), serde.serialize(new User(25,"小明明",6), inspector));
        writer.write(NullWritable.get(), serde.serialize(new User(26,"小军军",7), inspector));
        writer.write(NullWritable.get(), serde.serialize(new User(27,"小利利",8), inspector));
        writer.close(Reporter.NULL);
        fs.close();
        System.out.println("write success .");
    }

    static class MyRow implements Writable {
        String name;
        int age;

        MyRow(String name,int age){
            this.name = name;
            this.age = age;
        }
        @Override
        public void readFields(DataInput arg0) throws IOException {
            throw new UnsupportedOperationException("no write");
        }
        @Override
        public void write(DataOutput arg0) throws IOException {
            throw new UnsupportedOperationException("no read");
        }

    }
}
