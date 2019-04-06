package com.eschool.common.utils;

import java.net.URL;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
/**
 * Ehcache缓存工具类
 * @author internet
 *
 */
public class EhcacheUtil {
	public static final String USER_CACHE_NAME = "eschool_user";

	public static final String USER_CACHE_PREFIX = "session_";

	/**缓存配置文件路径：ClassPath根目录下的相对路径：即src下*/
	private static final String path = "/ehcache.xml";

	private URL url;

	private CacheManager manager;

	private static EhcacheUtil ehCache;

	private EhcacheUtil(String path) {
		url = getClass().getResource(path);
		manager = CacheManager.create(url);
	}
	
	public static EhcacheUtil getInstance() {
		if (ehCache == null) {
			ehCache = new EhcacheUtil(path);
		}
		return ehCache;
	}

	/**
	 * 以键值对形式将数据保存到指定缓存名称的缓存中
	 * @param cacheName 缓存名称，对应配置文件的name属性值
	 * @param key 键
	 * @param value 值
	 */
	public void put(String cacheName, String key, Object value) {
		Cache cache = manager.getCache(cacheName);
		Element element = new Element(key, value);
		cache.put(element);
	}

	/**
	 * 根据缓存名称和键获取缓存
	 * @param cacheName 缓存名称
	 * @param key 键
	 * @return 没有这个key则返回Null
	 */
	public Object get(String cacheName, String key) {
		Cache cache = manager.getCache(cacheName);
		Element element = cache.get(key);
		return element == null ? null : element.getObjectValue();
	}
	
	/**
	 * 根据缓存名称获取整个缓存对象
	 * @param cacheName 缓存名称
	 * @return
	 */
	public Cache get(String cacheName) {
		return manager.getCache(cacheName);
	}

	/**
	 * 根据缓存名和key移除缓存
	 * @param cacheName 缓存名称
	 * @param key 
	 */
	public void remove(String cacheName, String key) {
		Cache cache = manager.getCache(cacheName);
		cache.remove(key);
	}

}