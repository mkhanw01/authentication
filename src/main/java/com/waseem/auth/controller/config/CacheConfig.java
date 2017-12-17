package com.waseem.auth.controller.config;

import com.waseem.auth.restmodel.MandatoryParameter;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;

import java.lang.reflect.Method;

/**
 * Created by khan on 12/13/17.
 */
@Configuration
@EnableCaching
public class CacheConfig extends CachingConfigurerSupport {
  @Bean
  public CacheManager cacheManager(RedisTemplate redisTemplate){
    return new RedisCacheManager(redisTemplate);
  }

  @Override
  @Bean
  public org.springframework.cache.interceptor.CacheErrorHandler errorHandler() {
    return new CacheErrorHandler();
  }

  @Override
  @Bean
  public KeyGenerator keyGenerator() {
    return new KeyGenerator() {
      @Override
      public Object generate(Object target, Method method, Object... params) {
        StringBuilder sb = new StringBuilder();
        sb.append(target.getClass().getName());
        sb.append(method.getName());
        for (Object obj : params) {
          if (obj instanceof MandatoryParameter)
            sb.append(((MandatoryParameter) obj).getStoreId());
          else
            sb.append(obj.toString());
        }
        return sb.toString();
      }
    };
  }
}
