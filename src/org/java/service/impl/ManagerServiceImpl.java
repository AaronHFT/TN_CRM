package org.java.service.impl;

import org.java.dao.ManagerDao;
import org.java.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
@Service("managerService")
public class ManagerServiceImpl implements ManagerService {
	@Autowired
    @Qualifier("managerDao")  
	private ManagerDao managerDao;

	public ManagerDao getManagerDao() {
		return managerDao;
	}

	public void setManagerDao(ManagerDao managerDao) {
		this.managerDao = managerDao;
	}
      
}
