package com.alibaba.otter.canal.client.adapter.es.test.sync;

import java.util.*;

import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.otter.canal.client.adapter.es.ESAdapter;
import com.alibaba.otter.canal.client.adapter.support.AdapterConfigs;
import com.alibaba.otter.canal.client.adapter.support.DatasourceConfig;
import com.alibaba.otter.canal.client.adapter.support.Dml;

public class UserSyncSingleTest {

    private ESAdapter esAdapter;

    @Before
    public void init() {
        AdapterConfigs.put("es", "mytest_user_single.yml");
        esAdapter = Common.init();
    }

    /**
     * 单表插入
     */
    @Test
    public void insertTest01() {
        Dml dml = new Dml();
        dml.setDestination("example");
        dml.setTs(new Date().getTime());
        dml.setType("INSERT");
        dml.setDatabase("mytest");
        dml.setTable("user");
        List<Map<String, Object>> dataList = new ArrayList<>();
        Map<String, Object> data = new LinkedHashMap<>();
        dataList.add(data);
        data.put("id", 1L);
        data.put("name", "Eric");
        data.put("role_id", 1L);
        data.put("c_time", new Date());

        dml.setData(dataList);

        esAdapter.getEsSyncService().sync(dml);

        GetResponse response = esAdapter.getTransportClient().prepareGet("mytest_user", "_doc", "1").get();
        Assert.assertEquals("Eric", response.getSource().get("_name"));
    }

    @Test
    public void ttt() {
        SearchResponse response = esAdapter.getTransportClient()
            .prepareSearch("mytest_user")
            .setTypes("_doc")
            .setQuery(QueryBuilders.termQuery("_id", 1L))
            .setSize(100)
            .get();
        for (SearchHit hit : response.getHits()) {
            System.out.println(hit.getSourceAsMap().get("name"));
        }
    }

    @After
    public void after() {
        esAdapter.destroy();
        DatasourceConfig.DATA_SOURCES.values().forEach(DruidDataSource::close);
    }
}
