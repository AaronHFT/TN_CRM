package org.java.dao.impl;


import org.hibernate.SessionFactory;
import org.java.dao.DevelopmentplanDao;
import org.java.entity.Developmentplan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
@Repository("developmentplanDao")
public class DevelopmentplanDaoImpl extends BaseDaoImpl<Developmentplan> implements DevelopmentplanDao {

	@Autowired
	public DevelopmentplanDaoImpl(@Qualifier("sessionFactory")SessionFactory sessionFactory) {
        this.setSessionFactory(sessionFactory);
    }
    
      public DevelopmentplanDaoImpl() {
    	
    }

}
