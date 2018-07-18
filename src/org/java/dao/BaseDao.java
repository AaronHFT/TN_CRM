package org.java.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
/**
 * 公共数据访问层接口
 * @author Administrator
 *T:表示它是一个占位符，当前不能确定类型，它的类型需要由子接口继承它的时候，由子类来确定它的类型
 */
public interface BaseDao<T> {
	public void add(T t);
	
	public T findById(Class<T> clazz,Serializable id);
	
	public void update(T t);
	
	public void del(Class<T> clazz,Serializable id);
	
	public List<T> findAll(String objName);
	
	public List<T> findAll(String hql,Object arg);
	
	public List<T> findAll(String hql,Object...args);
	
	public Integer getCount(String tabName);
	
	public List<T> findByCriteria(DetachedCriteria dc);
	
	public List<T> findByCriteria(DetachedCriteria dc,Integer startIndex,Integer size);
	
	public List<T> findPage(String objName,Integer startIndex,Integer size);
}
