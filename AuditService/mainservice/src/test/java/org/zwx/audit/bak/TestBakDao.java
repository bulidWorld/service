package org.zwx.audit.bak;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zwx.audit.dao.BakDao;
import org.zwx.audit.model.QueryCondition;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:mybatis-spring_config.xml")
public class TestBakDao {

    @Autowired
    private BakDao bakDao;

    @Test
    public void testGetCount() {
        Map<String, Object> map = new HashMap<>();
        map.put("tableName", "tbl_test");
        Long count = bakDao.getTableCount(map);

        System.out.println(count);
    }

    @Test
    public void testGetColumns() {
        Map<String, Object> map = new HashMap<>();
        map.put("tableName", "tbl_test");
        List<String> lst = bakDao.getColumns(map);

        System.out.println(lst);
        System.out.println(lst.getClass());
    }

    @Test
    public void testGetResult() {
        QueryCondition queryCondition = new QueryCondition();
        queryCondition.setOrderColumn("id");
        queryCondition.setFrom(0L);
        queryCondition.setTo(2L);
        queryCondition.setTableName("tbl_test");

        List<Map<String, Object>> lst = bakDao.getResultLst(queryCondition);

        System.out.println(lst);
        System.out.println(lst.get(0).getClass());
    }
}
