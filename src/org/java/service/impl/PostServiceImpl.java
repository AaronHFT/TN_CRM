package org.java.service.impl;

import java.util.List;

import org.java.dao.PostDao;
import org.java.entity.Post;
import org.java.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
@Service("postService")
public class PostServiceImpl implements PostService {
	@Autowired
    @Qualifier("postDao")  
	private PostDao postDao;

	public PostDao getPostDao() {
		return postDao;
	}

	public void setPostDao(PostDao postDao) {
		this.postDao = postDao;
	}

	/**
	 * 查询所有职位
	 */
	@Override
	public List<Post> findAllPost() {
		List<Post> posts=postDao.findAll("Post");
		return posts;
	}
      
}
