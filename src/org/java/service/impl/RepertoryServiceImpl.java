package org.java.service.impl;

import org.java.dao.RepertoryDao;
import org.java.service.RepertoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
@Service("repertoryService")
public class RepertoryServiceImpl implements RepertoryService {
	@Autowired
    @Qualifier("repertoryDao")  
	private RepertoryDao repertoryDao;

	public RepertoryDao getRepertoryDao() {
		return repertoryDao;
	}

	public void setRepertoryDao(RepertoryDao repertoryDao) {
		this.repertoryDao = repertoryDao;
	}
      
}
