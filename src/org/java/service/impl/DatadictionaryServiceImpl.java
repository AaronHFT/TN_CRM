package org.java.service.impl;

import org.java.dao.DatadictionaryDao;
import org.java.service.DatadictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
@Service("datadictionaryService")
public class DatadictionaryServiceImpl implements DatadictionaryService {
	@Autowired
    @Qualifier("datadictionaryDao")   
	private DatadictionaryDao datadictionaryDao;

	public DatadictionaryDao getDatadictionaryDao() {
		return datadictionaryDao;
	}

	public void setDatadictionaryDao(DatadictionaryDao datadictionaryDao) {
		this.datadictionaryDao = datadictionaryDao;
	}
       
}
