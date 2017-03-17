package com.mpen.api.service.impl;

/**
 * Created by yx on 2015/10/20.
 */

import com.mpen.api.service.CacheServiceInterface;
import com.whaty.framework.cache.core.model.Cache;
import com.whaty.framework.cache.core.service.CacheService;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

import java.util.Map;

/**
 * Created by yx on 15-9-15.
 */
@Component("cacheServiceInterface")
public class CacheServiceInterfaceImp implements CacheServiceInterface {
    private static final Logger logger = Logger.getLogger(CacheServiceInterfaceImp.class);
    @Resource(name = "cacheService")
    private CacheService cacheService;
    private static final String  DEFAULTCACHE ="com.whaty.module.comment.defaultCache";
    private static Cache cache;

    private static boolean dev = false;

    /**
     * 设置默认缓存块
     */
    private void initDefaultCache(){
        if(null != cacheService && null == cache ){
            cache = cacheService.getCache(DEFAULTCACHE);
        }
    }

    /**
     * 初始化站点信息缓存块
     */
    private Cache getCache(String cacheBlock){
        if(null != cacheService){
            Cache cache = cacheService.getCache(cacheBlock);
            logger.debug(ReflectionToStringBuilder.toString(cache));
            return cache;
        }
        return null;
    }


    @Override
    public boolean put(String key, Object val) {
        return put(key, val, 0);
    }

    @Override
    public boolean put(String key, Object val, int expire) {
        return put(null, key, val, expire);
    }

    @Override
    public boolean put(String cacheBlock, String key, Object val, int expire){
        logger.debug(key + ReflectionToStringBuilder.toString(val));
        if(StringUtils.isBlank(cacheBlock)){
            //使用默认缓存块
            initDefaultCache();
            return cache.put(key, val, expire);
        } else {
            Cache cache = getCache(cacheBlock);
            return cache.put(key, val, expire);
        }
    }


    public boolean putMap(String key, Map<String, Object> val) {
        return putMap(key, val, 0);
    }

    public boolean putMap(String key, Map<String, Object> val, int expire){
        return putMap(null, key, val, expire);
    }

    public boolean putMap(String cacheBlock, String key, Map<String, Object> val, int expire){
        logger.debug(key + ReflectionToStringBuilder.toString(val));
        if(StringUtils.isBlank(cacheBlock)){
            //使用默认缓存块
            initDefaultCache();
            return cache.putMap(key, val, expire);
        } else {
            Cache cache = getCache(cacheBlock);
            return cache.putMap(key, val, expire);
        }
    }

    @Override
    public boolean putIntoMap(String cacheKey, String mapKey, Object val){
        return putIntoMap(null, cacheKey, mapKey, val);
    }


    @Override
    public boolean putIntoMap(String cacheBlock, String cacheKey, String mapKey, Object val){
        if(StringUtils.isBlank(cacheBlock)){
            //使用默认缓存块
            initDefaultCache();
            //缓存key 存在
            if(cache.exists(cacheKey)){
                return cache.putIntoMap(cacheKey, mapKey, val);
            }
            logger.debug("缓存:" + cacheKey + "不存在");
            return false;
        } else {
            Cache cache = getCache(cacheBlock);
            if(cache.exists(cacheKey)){
                return cache.putIntoMap(cacheKey, mapKey, val);
            }
            logger.debug("缓存:" + cacheKey + "不存在");
            return false;
        }
    }


    @Override
    public boolean remove(String key) {
        return remove(null, key);
    }

    @Override
    public boolean remove(String cacheBlock, String key) {
        if(StringUtils.isBlank(cacheBlock)){
            initDefaultCache();
            Object result = cache.remove(key);
            if(null != result){
                return true;
            }
            return false;
        }else{
            Cache cache = getCache(cacheBlock);
            Object val = cache.remove(key);
            if(null != val){
                return true;
            }
            return false;
        }
    }


    @Override
    public Object get(String key) {
        return get(null, key);
    }

    @Override
    public Object get(String cacheBlock, String key) {
        if(dev){
            return null;
        }
        Object val = null;
        if(StringUtils.isBlank(cacheBlock)){
            initDefaultCache();
            val = cache.get(key);
        }else{
            Cache cache = getCache(cacheBlock);
            val = cache.get(key);
        }
        logger.debug(key + ":" + ReflectionToStringBuilder.toString(val));
        return val;
    }

    @Override
    public Map<String, Object> getMap(String key){
        return getMap(null, key);
    }

    @Override
    public Map<String, Object> getMap(String cacheBlock, String key){
        if(dev){
            return null;
        }
        Map<String, Object> val = null;
        if(StringUtils.isBlank(cacheBlock)){
            initDefaultCache();
            val = cache.getMap(key);
        }else{
            Cache cache = getCache(cacheBlock);
            val = cache.getMap(key);
        }
        logger.debug(key + ":" + ReflectionToStringBuilder.toString(val));
        return val;
    }

    @Override
    public Object getFromMap(String cacheKey, String mapKey){
        return getFromMap(null, cacheKey, mapKey);
    }

    @Override
    public Object getFromMap(String cacheBlock, String cacheKey, String mapKey){
        if(dev){
            return null;
        }
        Object val = null;
        if(StringUtils.isBlank(cacheBlock)){
            initDefaultCache();
            val = cache.getFromMap(cacheKey, mapKey);
        }else{
            Cache cache = getCache(cacheBlock);
            val = cache.getFromMap(cacheKey, mapKey);
        }
        logger.debug(cacheKey + "->" +mapKey + ":" + ReflectionToStringBuilder.toString(val));
        return val;
    }

    @Override
    public boolean exists(String cacheKey){
        return exists(null, cacheKey);
    }

    @Override
    public boolean exists(String cacheBlock, String cacheKey){
        if(StringUtils.isBlank(cacheBlock)){
            initDefaultCache();
            return cache.exists(cacheKey);
        }else{
            Cache cache = getCache(cacheBlock);
            return cache.exists(cacheKey);
        }
    }
}
