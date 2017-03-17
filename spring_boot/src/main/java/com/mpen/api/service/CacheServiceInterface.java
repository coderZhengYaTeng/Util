package com.mpen.api.service;

import java.util.Map;

/**
 * Created by yx on 2015/10/20.
 */
public interface CacheServiceInterface {

    /**
     * 放入缓存 默认缓存块,永不过期
     * @param key 缓存key
     * @param val 值
     * @return
     */
    public boolean put(String key, Object val);

    /**
     * 放入缓存 默认缓存块
     * @param key  键
     * @param val  值
     * @param expire 过期时间（秒）
     * @return
     */
    public boolean put(String key, Object val, int expire);

    /**
     * 放入缓存
     * @param cacheBlock 缓存块
     * @param key   键
     * @param val   值
     * @param expire    过期时间（秒）
     * @return
     */
    public boolean put(String cacheBlock, String key, Object val, int expire);

    /**
     * 根据 key 获取缓存 默认缓存块
     * @param key
     * @return
     */
    public Object get(String key);

    /**
     * 根据 key 获取缓存
     * @param cacheBlock 缓存块
     * @param key
     * @return
     */
    public Object get(String cacheBlock, String key);

    /**
     * 移除指定缓存 默认缓存块
     * @param key   键
     * @return
     */
    public boolean remove(String key);

    /**
     * 移除指定缓存
     * @param cacheBlock 缓存块
     * @param key   键
     * @return
     */
    public boolean remove(String cacheBlock, String key);


    /**
     * 缓存中取出map格式的数据
     * 默认缓存块
     * @param key
     * @return
     */
    public Map<String, Object> getMap(String key);

    /**
     * 缓存中取出map格式的数据
     * @param cacheBlock 缓存块
     * @param key
     * @return
     */
    public Map<String, Object> getMap(String cacheBlock, String key);


    /**
     * 从缓存的map中获取对象
     * 默认缓存块
     * @param cacheKey 缓存key
     * @param mapKey map key
     * @return
     */
    public Object getFromMap(String cacheKey, String mapKey);

    /**
     * 从缓存的map中获取对象
     * @param cacheBlock 缓存块
     * @param cacheKey 缓存key
     * @param mapKey map key
     * @return
     */
    public Object getFromMap(String cacheBlock, String cacheKey, String mapKey);

    /**
     * 将map 放入缓存, 永不过期
     * 默认缓存块
     * @param key
     * @param val
     * @return
     */
    public boolean putMap(String key, Map<String, Object> val);

    /**
     * 将map 放入缓存
     * 默认缓存块
     * @param key
     * @param val
     * @param expire 过期时间 (秒)
     * @return
     */
    public boolean putMap(String key, Map<String, Object> val, int expire);

    /**
     * 将map 放入缓存
     * @param cacheBlock 缓存块
     * @param key
     * @param val
     * @param expire 过期时间 (秒)
     * @return
     */
    public boolean putMap(String cacheBlock, String key, Map<String, Object> val, int expire);

    /**
     * 將對放入已經存在的緩存map中
     * 默认缓存块
     * @param cacheKey 缓存 key
     * @param mapKey map key
     * @param val 缓存对象
     * @return
     */
    public boolean putIntoMap(String cacheKey, String mapKey, Object val);

    /**
     * 將對放入已經存在的緩存map中
     * @param cacheBlock 缓存块
     * @param cacheKey 缓存key
     * @param mapKey map key
     * @param val 缓存对象
     * @return
     */
    public boolean putIntoMap(String cacheBlock, String cacheKey, String mapKey, Object val);

    /**
     * 判断缓存是否存在
     * 默认缓存块
     * @param cacheKey
     * @return
     */
    public boolean exists(String cacheKey);

    /**
     * 判断缓存是否存在
     * @param cacheBlock
     * @param cacheKey
     * @return
     */
    public boolean exists(String cacheBlock, String cacheKey);

//    /**
//     * 清除缓存块
//     * @param cacheBlock
//     */
//    public void removeCache(String cacheBlock);

}