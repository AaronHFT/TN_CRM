package org.java.service.impl;

import org.java.dao.CustomerserveDao;
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
       
}
