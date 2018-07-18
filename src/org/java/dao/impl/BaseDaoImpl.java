package org.java.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.java.dao.BaseDao;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
/**
 * 公共Dao接口实现类
 * 
 * @author Administrator T:它的类型，也需要由子类来决定
 * 
 */
@SuppressWarnings("unchecked")
public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {
	@Override
	public void add(T t) {
		getHibernateTemplate().save(t);
	}

	@Override
	public T findById(Class<T> clazz, Serializable id) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(clazz, id);
	}

	@Override
	public void update(T t) {
		getHibernateTemplate().update(t);
	}

	@Override
	public void del(Class<T> clazz, Serializable id) {
		getHibernateTemplate().delete(getHibernateTemplate().get(clazz, id));
	}

	@Override
	public List<T> findAll(String objName) {
		// TODO Auto-generated method stub
		return (List<T>) getHibernateTemplate().find("from " + objName);
	}

	@Override
	public List<T> findAll(String hql, Object arg) {
		// TODO Auto-generated method stub
		return (List<T>) getHibernateTemplate().find(hql, arg);
	}

	@Override
	public List<T> findAll(String hql, Object... args) {
		// TODO Auto-generated method stub
		return (List<T>) getHibernateTemplate().find(hql, args);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Integer getCount(final String tabName) {
		// TODO Auto-generated method stub
		return (Integer) getHibernateTemplate().execute(new HibernateCallback() {

			@Override
			public Object doInHibernate(Session ses) throws HibernateException {
				String sql = "select count(*) from " + tabName;
				Query query = ses.createSQLQuery(sql);
				Integer count = Integer.parseInt(query.uniqueResult()
						.toString());
				return count;
			}

		});
	}

	@Override
	public List<T> findByCriteria(DetachedCriteria dc) {
		// TODO Auto-generated method stub
		return (List<T>) getHibernateTemplate().findByCriteria(dc);
	}

	@Override
	public List<T> findByCriteria(DetachedCriteria dc, Integer startIndex, Integer size) {
		// TODO Auto-generated method stub
		return (List<T>) getHibernateTemplate().findByCriteria(dc,startIndex,size);
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public List<T> findPage(final String objName, final Integer startIndex,
			final Integer size) {

		return (List<T>) getHibernateTemplate().execute(new HibernateCallback() {

			@Override
			public Object doInHibernate(Session ses) throws HibernateException {
				String hql = "from " + objName;
				Query query = ses.createQuery(hql);
				query.setFirstResult(startIndex);
				query.setMaxResults(size);

				return query.list();
			}

		});
	}

}
