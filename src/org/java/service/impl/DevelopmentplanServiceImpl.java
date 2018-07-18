package org.java.service.impl;

import org.java.dao.DevelopmentplanDao;
import org.java.service.DevelopmentplanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
@Service("developmentplanService")
public class DevelopmentplanServiceImpl implements DevelopmentplanService {
	@Autowired
    @Qualifier("developmentplanDao")   
	private DevelopmentplanDao developmentplanDao;

	public DevelopmentplanDao getDevelopmentplanDao() {
		return developmentplanDao;
	}

	public void setDevelopmentplanDao(DevelopmentplanDao developmentplanDao) {
		this.developmentplanDao = developmentplanDao;
	}
	
}
