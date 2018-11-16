package com.xiewendomg.admin.bigdata;

import com.alibaba.fastjson.JSON;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.util.StringUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MapperTest extends Mapper<LongWritable, Text, Text, IntWritable> {
    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context)
            throws IOException, InterruptedException {
        String word[] = StringUtils.split(value.toString(), ' ');
        for (String s : word) {
            context.write(new Text(s), new IntWritable(1));
        }
    }


    public static void main(String[] args) {
        List<User> list=new ArrayList();
        list.add(new User(24,"小红红",5));
        list.add(new User(25,"小明明",6));
        list.add(new User(26,"小军军",7));
        list.add(new User(27,"小利利",8));
        System.out.println(JSON.toJSONString(list));
    }
}
