package com.eschool.common.base;

import java.util.List;
import java.util.Map;

/**
 * @Auther: Aaron
 * @Date: 2018-11-14 09:11:56
 * @Description: 基础Dao(还需在XML文件里，有对应的SQL语句)
 */
public interface BaseDao<T> {
	
	void save(T t);
	
//	void save(Map<String, Object> map);
//
//	void saveBatch(List<T> list);
//
	int update(T t);
//
//	int update(Map<String, Object> map);
//
	int delete(Object id);
//
//	int delete(Map<String, Object> map);
//
	int deleteBatch(Object[] id);
//
	T queryObject(Object id);
//
	List<T> queryList(Map<String, Object> map);
//
	int queryTotal(Map<String, Object> map);
//
//	int queryTotal();
}
