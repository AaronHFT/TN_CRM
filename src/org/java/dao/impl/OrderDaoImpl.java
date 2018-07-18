package org.java.dao.impl;

import org.hibernate.SessionFactory;
import org.java.dao.OrderDao;
import org.java.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
@Repository("orderDao")
public class OrderDaoImpl extends BaseDaoImpl<Order> implements OrderDao {
	@Autowired
	public OrderDaoImpl(@Qualifier("sessionFactory")SessionFactory sessionFactory) {
        this.setSessionFactory(sessionFactory);
    }
    
      public OrderDaoImpl() {
    	
    }
}
