package org.java.service.impl;

import org.java.dao.ModelDao;
import org.java.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
@Service("modelService")
public class ModelServiceImpl implements ModelService {
       
	@Autowired
    @Qualifier("modelDao")
	private ModelDao modelDao;

	public ModelDao getModelDao() {
		return modelDao;
	}

	public void setModelDao(ModelDao modelDao) {
		this.modelDao = modelDao;
	}
       
}
