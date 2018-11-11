package com.xiewendomg.admin.bigdata;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

import java.util.Map;

public class JobTest {
    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        // "localhost:9000" 需要根据实际情况设置一下
        conf.set("mapred.job.tracker", "localhost:9000");
        // 一个hdfs文件系统中的 输入目录 及 输出目录
        String[] ioArgs = new String[] { "input/score", "output" };
        String[] otherArgs = new GenericOptionsParser(conf, ioArgs).getRemainingArgs();
        if (otherArgs.length != 2) {
            System.err.println("Usage: Score Average <in> <out>");
            System.exit(2);
        }

        Job job = new Job(conf, "Score Average");
        job.setJarByClass(JobTest.class);
        // 设置Map、Combine和Reduce处理类
        job.setMapperClass(MapperTest.class);
        job.setCombinerClass(ReduceTest.class);
        job.setReducerClass(ReduceTest.class);
        // 设置输出类型
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        // 将输入的数据集分割成小数据块splites，提供一个RecordReder的实现
        job.setInputFormatClass(TextInputFormat.class);
        // 提供一个RecordWriter的实现，负责数据输出
        job.setOutputFormatClass(TextOutputFormat.class);
        // 设置输入和输出目录
        FileInputFormat.addInputPath(job, new Path(otherArgs[0]));
        FileOutputFormat.setOutputPath(job, new Path(otherArgs[1]));
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
