package org.java.dao.impl;


import org.hibernate.SessionFactory;
import org.java.dao.CustomerinfoDao;
import org.java.entity.Customerinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
@Repository("customerinfoDao")
public class CustomerinfoDaoImpl extends BaseDaoImpl<Customerinfo> implements CustomerinfoDao {
	@Autowired
	public CustomerinfoDaoImpl(@Qualifier("sessionFactory")SessionFactory sessionFactory) {
        this.setSessionFactory(sessionFactory);
    }
    
      public CustomerinfoDaoImpl() {
    	
    }

}
