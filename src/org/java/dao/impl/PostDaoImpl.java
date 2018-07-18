package org.java.dao.impl;

import org.hibernate.SessionFactory;
import org.java.dao.PostDao;
import org.java.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
@Repository("postDao")
public class PostDaoImpl extends BaseDaoImpl<Post> implements PostDao {
	@Autowired
	public PostDaoImpl(@Qualifier("sessionFactory")SessionFactory sessionFactory) {
        this.setSessionFactory(sessionFactory);
    }
    
      public PostDaoImpl() {
    	
    }
}
