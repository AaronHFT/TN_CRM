package org.java.dao.impl;

import org.hibernate.SessionFactory;
import org.java.dao.ModelDao;
import org.java.entity.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
@Repository("modelDao")
public class ModelDaoImpl extends BaseDaoImpl<Model> implements ModelDao {
	@Autowired
	public ModelDaoImpl(@Qualifier("sessionFactory")SessionFactory sessionFactory) {
        this.setSessionFactory(sessionFactory);
    }
    
      public ModelDaoImpl() {
    	
    }
}
