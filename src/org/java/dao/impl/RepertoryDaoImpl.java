package org.java.dao.impl;

import org.hibernate.SessionFactory;
import org.java.dao.RepertoryDao;
import org.java.entity.Repertory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
@Repository("repertoryDao")
public class RepertoryDaoImpl extends BaseDaoImpl<Repertory> implements RepertoryDao {
	@Autowired
	public RepertoryDaoImpl(@Qualifier("sessionFactory")SessionFactory sessionFactory) {
        this.setSessionFactory(sessionFactory);
    }
    
      public RepertoryDaoImpl() {
    	
    }
}
