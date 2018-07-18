package org.java.dao.impl;

import org.hibernate.SessionFactory;
import org.java.dao.RelationpeopleDao;
import org.java.entity.Relationpeople;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
@Repository("relationpeopleDao")
public class RelationpeopleDaoImpl extends BaseDaoImpl<Relationpeople> implements RelationpeopleDao {
	@Autowired
	public RelationpeopleDaoImpl(@Qualifier("sessionFactory")SessionFactory sessionFactory) {
        this.setSessionFactory(sessionFactory);
    }
    
      public RelationpeopleDaoImpl() {
    	
    }
}
