package org.java.service.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.java.dao.CustomerserveDao;
import org.java.entity.Customerserve;
import org.java.service.CustomerserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
@Service("customerserveService")
public class CustomerserveServiceImpl implements CustomerserveService {
	@Autowired
    @Qualifier("customerserveDao")  
	private CustomerserveDao customerserveDao;

	public CustomerserveDao getCustomerserveDao() {
		return customerserveDao;
	}

	public void setCustomerserveDao(CustomerserveDao customerserveDao) {
		this.customerserveDao = customerserveDao;
	}

	
	/**
	 * 新增一个新创建的服务
	 */
	@Override
	public void addCS(Customerserve cs) {
		customerserveDao.add(cs);
	}

	/**
	 * 查询所有待分配的服务
	 */
	@Override
	public List<Customerserve> findDivids() {
		DetachedCriteria dc=DetachedCriteria.forClass(Customerserve.class);
		dc.add(Restrictions.eq("statu", "新创建"));
		dc.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		List<Customerserve> csList=customerserveDao.findByCriteria(dc);
		return csList;
	}

	/**
	 * 通过编号查询获取客户服务
	 */
	@Override
	public Customerserve findByCSId(Serializable id) {
		DetachedCriteria dc=DetachedCriteria.forClass(Customerserve.class);
		dc.add(Restrictions.eq("id", id));
		Customerserve cs=customerserveDao.findByCriteria(dc).size()==0?null:customerserveDao.findByCriteria(dc).get(0);
		return cs;
	}

	
	/**
	 * 更新客户服务信息
	 */
	@Override
	public void updateCS(Customerserve cs) {
		customerserveDao.update(cs);
	}

	/**
	 * 根据信息查询相应的服务信息
	 */
	@Override
	public List<Customerserve> findList(String msg) {
		DetachedCriteria dc=DetachedCriteria.forClass(Customerserve.class);
		dc.add(Restrictions.eq("statu",msg));
		dc.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		List<Customerserve> csList=customerserveDao.findByCriteria(dc);
		return csList;
	}
       
}
