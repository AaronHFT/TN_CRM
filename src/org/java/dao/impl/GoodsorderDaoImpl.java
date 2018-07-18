package org.java.dao.impl;

import org.hibernate.SessionFactory;
import org.java.dao.GoodsorderDao;
import org.java.entity.Goodsorder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
@Repository("goodsorderDao")
public class GoodsorderDaoImpl extends BaseDaoImpl<Goodsorder> implements GoodsorderDao {
	@Autowired
	public GoodsorderDaoImpl(@Qualifier("sessionFactory")SessionFactory sessionFactory) {
        this.setSessionFactory(sessionFactory);
    }
    
      public GoodsorderDaoImpl() {
    	
    }
}
