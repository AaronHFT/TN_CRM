package org.java.service.impl;

import org.java.dao.OrderDao;
import org.java.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
@Service("orderService")
public class OrderServiceImpl implements OrderService {
	@Autowired
    @Qualifier("orderDao") 
	private OrderDao orderDao;

	public OrderDao getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
      
}
