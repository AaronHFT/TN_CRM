package org.java.service.impl;

import org.java.dao.SellchanceDao;
import org.java.service.SellchanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
@Service("sellchanceService")
public class SellchanceServiceImpl implements SellchanceService {
	@Autowired
    @Qualifier("sellchanceDao")  
	private SellchanceDao sellchanceDao;

	public SellchanceDao getSellchanceDao() {
		return sellchanceDao;
	}

	public void setSellchanceDao(SellchanceDao sellchanceDao) {
		this.sellchanceDao = sellchanceDao;
	}
      
}
