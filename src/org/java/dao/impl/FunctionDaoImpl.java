package org.java.dao.impl;

import org.hibernate.SessionFactory;
import org.java.dao.FunctionDao;
import org.java.entity.Function;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
@Repository("functionDao")
public class FunctionDaoImpl extends BaseDaoImpl<Function> implements FunctionDao {
	@Autowired
	public FunctionDaoImpl(@Qualifier("sessionFactory")SessionFactory sessionFactory) {
        this.setSessionFactory(sessionFactory);
    }
    
      public FunctionDaoImpl() {
    	
    }
}
