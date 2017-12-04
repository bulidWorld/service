package org.zwx.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.ConnectionUtils;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Connection;

@Repository
public class RedisDao {

    @Autowired
    RedisConnectionFactory connectionFactory;

    private RedisConnection getConnection() {
        return connectionFactory.getConnection();
    }

    public boolean save(String key, String value, String namespace) {
        String redisKey = namespace + key;
        return getConnection().set(redisKey.getBytes(), value.getBytes());
    }

    public String get(String key, String namespace) {
        String redisKey = namespace + key;
       return new String(getConnection().get(redisKey.getBytes()));
    }

}
