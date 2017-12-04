package org.zwx.dao;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.zwx.common.DBType;

@Configuration
public class RedisConfig {

    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        DBChooser dbChooser = DBChooser.getInstance();
        DBEntity dbEntity = dbChooser.chooseDB(DBType.REDIS);
        RedisStandaloneConfiguration standaloneConfiguration = new RedisStandaloneConfiguration();
        standaloneConfiguration.setHostName(dbEntity.getHostName());
        standaloneConfiguration.setPort(dbEntity.getPort());
        if (StringUtils.isNotEmpty(dbEntity.getPwd())) {
            standaloneConfiguration.setPassword(RedisPassword.of(dbEntity.getPwd()));
        }

        RedisConnectionFactory connectionFactory = new JedisConnectionFactory(standaloneConfiguration);
        return connectionFactory;

    }
}
