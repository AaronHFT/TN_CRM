package org.java.service.impl;

import org.java.dao.GoodsorderDao;
import org.java.service.GoodsorderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
@Service("goodsorderService")
public class GoodsorderServiceImpl implements GoodsorderService {
	@Autowired
    @Qualifier("goodsorderDao")  
	private GoodsorderDao goodsorderDao;

	public GoodsorderDao getGoodsorderDao() {
		return goodsorderDao;
	}

	public void setGoodsorderDao(GoodsorderDao goodsorderDao) {
		this.goodsorderDao = goodsorderDao;
	}
      
}
