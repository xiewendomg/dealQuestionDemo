package com.xiewendomg.admin.bigdata.hive;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Iterator;

public class ReduceModel extends Reducer<Text, String, Text, IntWritable> {

    // 实现reduce函数
    public void reduce(Text key, Iterable<String> values,
                       Context context) throws IOException, InterruptedException {
        int sum = 0;
        int count = 0;
        Iterator<String> iterator = values.iterator();
        while (iterator.hasNext()) {
            //sum += iterator.next().get();// 计算总分
            count++;// 统计总的科目数
        }
        int average = (int) sum / count;// 计算平均成绩
        context.write(key, new IntWritable(average));
    }
    @Override
    public void run(Context context) throws IOException, InterruptedException {
        super.run(context);
    }
}
