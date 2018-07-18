package org.java.dao.impl;

import org.hibernate.SessionFactory;
import org.java.dao.ManagerDao;
import org.java.entity.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
@Repository("managerDao")
public class ManagerDaoImpl extends BaseDaoImpl<Manager> implements ManagerDao {
	@Autowired
	public ManagerDaoImpl(@Qualifier("sessionFactory")SessionFactory sessionFactory) {
        this.setSessionFactory(sessionFactory);
    }
    
      public ManagerDaoImpl() {
    	
    }
}
