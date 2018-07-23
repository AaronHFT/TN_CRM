package org.java.service.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.java.dao.ManagerDao;
import org.java.entity.Manager;
import org.java.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
@Service("managerService")
public class ManagerServiceImpl implements ManagerService {
	@Autowired
    @Qualifier("managerDao")  
	private ManagerDao managerDao;

	public ManagerDao getManagerDao() {
		return managerDao;
	}

	public void setManagerDao(ManagerDao managerDao) {
		this.managerDao = managerDao;
	}

	
	/**
	 * 登录验证
	 */
	@Override
	public Manager findByLogin(String account, String pwd) {
		DetachedCriteria dc=DetachedCriteria.forClass(Manager.class);
		dc.add(Restrictions.and(Restrictions.eq("account", account),Restrictions.eq("pwd", pwd)));
		Manager manager=managerDao.findByCriteria(dc).size()==0?null:managerDao.findByCriteria(dc).get(0);
		return manager;
	}

	/**
	 * 查询返回所有在职客户经理
	 */
	@Override
	public List<Manager> findAllManager() {
		DetachedCriteria dc=DetachedCriteria.forClass(Manager.class);
		dc.add(Restrictions.eq("statu", "在职"));
		dc.createAlias("post", "p").add(Restrictions.eq("p.name", "客户经理"));
		dc.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		List<Manager> mList=managerDao.findByCriteria(dc);
		return mList;
	}

	/**
	 * 通过Id获取相应的客户经理
	 */
	@Override
	public Manager findByDividId(Serializable id) {
		DetachedCriteria dc=DetachedCriteria.forClass(Manager.class);
		dc.add(Restrictions.eq("id", id));
		Manager manager=managerDao.findByCriteria(dc).size()==0?null:managerDao.findByCriteria(dc).get(0);
		return manager;
	}
      
}
