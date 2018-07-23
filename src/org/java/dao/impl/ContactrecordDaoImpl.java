package org.java.dao.impl;

import org.hibernate.SessionFactory;
import org.java.dao.ContactrecordDao;
import org.java.entity.Contactrecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
@Repository("contactrecordDao")
public class ContactrecordDaoImpl extends BaseDaoImpl<Contactrecord> implements ContactrecordDao {

	@Autowired
	public ContactrecordDaoImpl(@Qualifier("sessionFactory")SessionFactory sessionFactory) {
        this.setSessionFactory(sessionFactory);
    }
	
    public ContactrecordDaoImpl() {	
           
    }
}
