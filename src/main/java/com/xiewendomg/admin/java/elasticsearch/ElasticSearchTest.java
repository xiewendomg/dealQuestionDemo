package com.xiewendomg.admin.java.elasticsearch;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.cluster.node.DiscoveryNode;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.bucket.histogram.DateHistogramInterval;
import org.elasticsearch.search.aggregations.bucket.terms.IncludeExclude;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import static org.elasticsearch.search.aggregations.Aggregation.*;

public class ElasticSearchTest {
    private static TransportClient client;
    private static IndexRequest source;

    public static void main(String[] args) {
        //获取client连接
        before2();
        try {
            testAggregation();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //关闭连接
        client.close();
    }

    /**
     * 测试聚合查询
     */
    public static void testAggregation() throws Exception {
        QueryBuilder queryBuilder = QueryBuilders.boolQuery().
                must(QueryBuilders.matchQuery("advisecontent", "种植")).
                must(QueryBuilders.matchQuery("advisecontent", "蔬菜")).
                must(QueryBuilders.matchQuery("advisecontent", "大棚"));
        IncludeExclude includeExclude = new IncludeExclude(null, new String[]{"什么", "哪里", "现在", "适合"});
        SearchResponse searchResponse = client.prepareSearch()
                .setSize(0)
                .setQuery(queryBuilder)
                .addAggregation(
                        AggregationBuilders.terms("mm").field("advisecontent").
                                size(10).includeExclude(includeExclude)
                ).execute().actionGet();

        // Get your facet results
        System.out.println(searchResponse.status());
        StringBuffer buffer = new StringBuffer();
        System.out.println(searchResponse.getHits() == null);
        Terms terms = searchResponse.getAggregations().get("mm");
        terms.getBuckets();
        for (Terms.Bucket bucket:terms.getBuckets()){
            System.out.println(bucket.getDocCount());
            System.out.println(bucket.getKey());
        }


        for (Aggregation aggregation : searchResponse.getAggregations()) {
        }
    }

    /**
     * 查看集群信息
     */
    public static void testInfo() {
        List<DiscoveryNode> nodes = client.connectedNodes();
        System.out.println(nodes.size() == 0);
        for (DiscoveryNode node : nodes) {
            System.out.println(node.getHostAddress());
        }
    }

    /**
     * 获取连接, 第一种方式
     *
     * @throws Exception
     */
    public static void before() {
        try {
            client = new PreBuiltTransportClient(Settings.EMPTY)
                    .addTransportAddress(new TransportAddress(InetAddress.getByName("slave1"), 9300));
        } catch (UnknownHostException e) {
            System.out.println("请输入正确的ip地址");
        }
    }

    /**
     * 获取连接, 第二种方式
     * Settings settings = Settings.builder()
     * .put("cluster.name", "es_cmazxiaoma_cluster").build();
     * client = new PreBuiltTransportClient(settings).
     *
     * @throws Exception
     */
    public static void before2() {
        try {
            Settings settings = Settings.builder()
                    .put("cluster.name", "es_cmazxiaoma_cluster").build();
            client = new PreBuiltTransportClient(settings).
                    addTransportAddress(new TransportAddress(InetAddress.getByName("slave1"), 9300));
        } catch (UnknownHostException e) {
            System.out.println("请输入正确的ip地址");
        }
    }


}