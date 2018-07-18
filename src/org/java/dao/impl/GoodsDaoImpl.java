package org.java.dao.impl;

import org.hibernate.SessionFactory;
import org.java.dao.GoodsDao;
import org.java.entity.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
@Repository("goodsDao")
public class GoodsDaoImpl extends BaseDaoImpl<Goods> implements GoodsDao {
	@Autowired
	public GoodsDaoImpl(@Qualifier("sessionFactory")SessionFactory sessionFactory) {
        this.setSessionFactory(sessionFactory);
    }
    
      public GoodsDaoImpl() {
    	
    }
}
