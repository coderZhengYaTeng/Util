package com.mpen.api.service.impl;

import java.util.Map.Entry;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import com.whaty.cache.serialize.RedisCache;
import com.whaty.framework.cache.core.model.Cache;
import com.whaty.framework.cache.core.model.EvictionPolicy;
import com.whaty.framework.cache.core.model.impl.AbstractCache;
import com.whaty.framework.cache.core.model.impl.RedisCacheImp;
import com.whaty.framework.cache.core.service.impl.DefaultRedisService;

/**
 * @author whaty
 *
 */
@Service("cacheService")
@PropertySource("redis.properties")
public class DefaultRedisServiceImpl extends DefaultRedisService {
	protected String redisConfigPath = "redis.properties";
	protected String defaultCacheName = "defaultCacheName";
	protected String cacheName;
	protected RedisCache redisCache;

	public DefaultRedisServiceImpl() {
		this("redis.properties", "defaultCacheName");
	}

	public DefaultRedisServiceImpl(String redisConfigPath, String cacheName) {
		this.redisConfigPath = redisConfigPath;
		this.cacheName = cacheName;
	}

	private RedisCache initRedisCache() {
		if (null == redisCache) {
			redisCache = new RedisCache(redisConfigPath);
			new Thread(new CacheRate(redisCache, caches)).start();
		}
		return redisCache;
	}

	public RedisCacheImp createCache() {
		RedisCacheImp red = new RedisCacheImp(getRedisCache(), cacheName);
		caches.put(cacheName, red);
		return red;
	}

	@Override
	protected Cache doAddCache(String name, int maxSize, boolean eternal, int tTLSeconds, EvictionPolicy evictionPolicy) {
		AbstractCache red = new RedisCacheImp(getRedisCache(), name);
		caches.put(name, red);
		return red;
	}

	@Override
	protected Cache initDefaultCache() {
		// 自動設置失效時間 tTLSeconds = 300000;//5 min
		return addCache(this.defaultCacheName);
	}

	@Override
	protected Cache getCacheFromCacheManager(String name) {
		// 根据字符串名称获得缓存块
		return caches.get(super.cacheNamePrefix + name);
	}

	/*
	 * 配置文件路径的确定
	 */
	public void setRedisConfigPath(String redisConfigPath) {
		this.redisConfigPath = redisConfigPath;
	}

	public String getRedisConfigPath() {
		return redisConfigPath;
	}

	public RedisCache getRedisCache() {
		return initRedisCache();
	}

	public void setRedisCache(RedisCache redisCache) {
		this.redisCache = redisCache;
	}

	@Override
	public String getPoolInfo() {
		return redisCache.getPoolInfo();
	}

}

class CacheRate implements Runnable {

	private int SLEEP_TIME = 10 * 60 * 1000;
	// private int SLEEP_TIME = 1*5*1000;

	private Logger logger = Logger.getLogger("whatycache");
	private RedisCache red = null;
	private ConcurrentMap<String, AbstractCache> caches = null;

	public CacheRate(RedisCache red, ConcurrentMap<String, AbstractCache> caches) {
		this.red = red;
		this.caches = caches;
	}

	@Override
	public void run() {
		while (true) {
			if (caches != null) {
				// 循环所有的缓存块
				for (Entry<String, AbstractCache> entry : caches.entrySet()) {
					AbstractCache cache = entry.getValue();
					AtomicLong times = cache.getTimes();
					AtomicLong good = cache.getGood();
					long lTimes = times.get();
					long lgood = good.get();
					if (red.addCacheRateInfo(cache.getCacheName(), lTimes, lgood)) {
						times.addAndGet(0 - lTimes);
						good.addAndGet(0 - lgood);
					}
				}
			}
			try {
				Thread.sleep(SLEEP_TIME);
			} catch (InterruptedException e) {
				logger.error("Thread error.", e);
			}
		}

	}

}
