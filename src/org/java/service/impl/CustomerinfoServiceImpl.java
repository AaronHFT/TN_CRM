package org.java.service.impl;

import java.util.List;

import org.java.dao.CustomerinfoDao;
import org.java.entity.Customerinfo;
import org.java.service.CustomerinfoService;
import org.java.service.CustomerserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
@Service("customerinfoService")
public class CustomerinfoServiceImpl implements CustomerinfoService {
	@Autowired
    @Qualifier("customerinfoDao")   
	private CustomerinfoDao customerinfoDao;

	public CustomerinfoDao getCustomerinfoDao() {
		return customerinfoDao;
	}

	public void setCustomerinfoDao(CustomerinfoDao customerinfoDao) {
		this.customerinfoDao = customerinfoDao;
	}

	/**
	 * 获取所有未流失的客户
	 */
	@Override
	public List<Customerinfo> findLiveCustomers() {
		String hql="from Customerinfo where statu !=?";
		List<Customerinfo> customerinfos=customerinfoDao.findAll(hql, "已流失");
		return customerinfos;
	}
       
}
