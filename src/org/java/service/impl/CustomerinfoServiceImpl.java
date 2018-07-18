package org.java.service.impl;

import org.java.dao.CustomerinfoDao;
import org.java.service.CustomerinfoService;
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
       
}
