package org.java.service.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.java.dao.DatadictionaryDao;
import org.java.entity.Customerserve;
import org.java.entity.Datadictionary;
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

	/*
	 * 获取所有服务类型(non-Javadoc)
	 * @see org.java.service.DatadictionaryService#findServiceType()
	 */
	@Override
	public List<Datadictionary> findServiceType() {
        String hql="from Datadictionary where type=?";
		List<Datadictionary> list=datadictionaryDao.findAll(hql, "服务类型");
		return list;
	}

	
	/**
	 * 通过类型名称获取相应的数据字典
	 */
	@Override
	public List<Datadictionary> findByTypes(String msg) {
		DetachedCriteria dc=DetachedCriteria.forClass(Datadictionary.class);
		dc.add(Restrictions.eq("type", msg));
		dc.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		List<Datadictionary> ddList=datadictionaryDao.findByCriteria(dc);
		return ddList;
	}
       
}
