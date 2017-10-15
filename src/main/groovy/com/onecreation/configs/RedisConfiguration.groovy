package com.onecreation.configs

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import redis.clients.jedis.JedisShardInfo

@Configuration
class RedisConfiguration {

    @Value('${redis.url}')
    String redisHostName

    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        JedisConnectionFactory  factory = new JedisConnectionFactory(new JedisShardInfo(redisHostName))
        return factory
    }

    @Bean
    RedisTemplate redisTemplate() {
        RedisTemplate<String, Object> template = new RedisTemplate<String, Object>()
        template.setConnectionFactory(jedisConnectionFactory())
        return template
    }
}
