package org.java.dao.impl;


import org.hibernate.SessionFactory;
import org.java.dao.CustomerserveDao;
import org.java.entity.Customerserve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
@Repository("customerserveDao")
public class CustomerserveDaoImpl extends BaseDaoImpl<Customerserve> implements CustomerserveDao {

	@Autowired
	public CustomerserveDaoImpl(@Qualifier("sessionFactory")SessionFactory sessionFactory) {
        this.setSessionFactory(sessionFactory);
    }
    
      public CustomerserveDaoImpl() {
    	
    }

}
