package com.xiewendomg.admin.java.analyzer_ik;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) throws IOException {
        String text="想回乡办养鸡场，咨询相关培训以及销售渠道";
        //创建分词对象
        List<String> list = new ArrayList<>();
        StringReader re = new StringReader(text);
        IKSegmenter ik = new IKSegmenter(re, false);
        Lexeme lex;
        StringBuffer stringBuffer=new StringBuffer();
        while ((lex = ik.next()) != null) {
            stringBuffer.append(lex.getLexemeText());
            System.out.println(lex.getLexemeText());
            list.add(lex.getLexemeText());
        }
        //分词
        //遍历分词数据

        System.out.println(stringBuffer.toString());
    }
}
