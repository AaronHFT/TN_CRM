package org.java.dao.impl;


import org.hibernate.SessionFactory;
import org.java.dao.DatadictionaryDao;
import org.java.entity.Datadictionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
@Repository("datadictionaryDao")
public class DatadictionaryDaoImpl extends BaseDaoImpl<Datadictionary> implements DatadictionaryDao {

	@Autowired
	public DatadictionaryDaoImpl(@Qualifier("sessionFactory")SessionFactory sessionFactory) {
        this.setSessionFactory(sessionFactory);
    }
    
      public DatadictionaryDaoImpl() {
    	
    }

}
