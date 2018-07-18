package org.java.dao.impl;

import org.hibernate.SessionFactory;
import org.java.dao.SellchanceDao;
import org.java.entity.Sellchance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
@Repository("sellchanceDao")
public class SellchanceDaoImpl extends BaseDaoImpl<Sellchance> implements SellchanceDao {
	@Autowired
	public SellchanceDaoImpl(@Qualifier("sessionFactory")SessionFactory sessionFactory) {
        this.setSessionFactory(sessionFactory);
    }
    
      public SellchanceDaoImpl() {
    	
    }
}
