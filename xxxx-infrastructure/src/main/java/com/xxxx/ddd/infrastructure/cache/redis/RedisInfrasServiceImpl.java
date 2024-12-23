package com.xxxx.ddd.infrastructure.cache.redis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Map;
import java.util.Optional;

@Component
@Slf4j
public class RedisInfrasServiceImpl implements RedisInfrasService {


    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public void setString(String key, String value) {
        if (!StringUtils.hasLength(key)) {
            return;
        }
        redisTemplate.opsForValue().set(key, value);
    }

    @Override
    public String getString(String key) {
        return Optional.ofNullable(redisTemplate.opsForValue().get(key))
                .map(String::valueOf)
                .orElse(null);
    }

    @Override
    public void setObject(String key, Object value) {
        if (!StringUtils.hasLength(key)) {
            return;
        }
        try {
            redisTemplate.opsForValue().set(key, value);
        }catch (Exception e){
            log.error("setObject error:{}", e.getMessage());
        }
    }

    @Override
    public <T> T getObject(String key, Class<T> targetClass) {
        Object result = redisTemplate.opsForValue().get(key);
        log.info("get Cache:{}", result);
        if(result == null){
            return null;
        }

        // If result is a LinkedHashMap
        if(result instanceof Map){
            try{
                // Transfer LinkedHashMap to target object
                ObjectMapper objectMapper = new ObjectMapper();
                return objectMapper.convertValue(result, targetClass);
            }catch (IllegalArgumentException e){
                log.error("Error converting LinkedHashMap to object:{}", e.getMessage());
            }
        }

        if(result instanceof String){
            try{
                ObjectMapper objectMapper = new ObjectMapper();
                return objectMapper.readValue((String) result, targetClass);
            }catch (JsonProcessingException e){
                log.error("Error deserializing JSON to object:{}", e.getMessage());
                return null;
            }
        }
        return null;
    }
}
