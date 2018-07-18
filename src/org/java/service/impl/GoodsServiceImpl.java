package org.java.service.impl;

import org.java.dao.GoodsDao;
import org.java.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {
	@Autowired
    @Qualifier("goodsDao")  
	private GoodsDao goodsDao;

	public GoodsDao getGoodsDao() {
		return goodsDao;
	}

	public void setGoodsDao(GoodsDao goodsDao) {
		this.goodsDao = goodsDao;
	}
      
}
