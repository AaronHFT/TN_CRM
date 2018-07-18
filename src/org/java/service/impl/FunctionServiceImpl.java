package org.java.service.impl;

import org.java.dao.FunctionDao;
import org.java.service.FunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
@Service("functionService")
public class FunctionServiceImpl implements FunctionService {
	@Autowired
    @Qualifier("functionDao")   
	private FunctionDao functionDao;

	public FunctionDao getFunctionDao() {
		return functionDao;
	}

	public void setFunctionDao(FunctionDao functionDao) {
		this.functionDao = functionDao;
	}
       
}
