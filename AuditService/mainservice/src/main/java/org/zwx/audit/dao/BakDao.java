package org.zwx.audit.dao;

import com.sun.corba.se.spi.ior.ObjectKey;
import org.mybatis.spring.annotation.MapperScan;
import org.zwx.audit.model.QueryCondition;

import java.util.List;
import java.util.Map;

@MapperScan
public interface BakDao {

    Long getTableCount(Map<String, Object> map);

    List<String> getColumns(Map<String, Object> map);

    List<Map<String, Object>> getResultLst(QueryCondition queryCondition);

    void delete(QueryCondition queryCondition);
}
