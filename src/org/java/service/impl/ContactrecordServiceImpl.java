package org.java.service.impl;

import org.java.dao.ContactrecordDao;
import org.java.service.ContactrecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
@Service("contactrecordService")
public class ContactrecordServiceImpl implements ContactrecordService {
	@Autowired
    @Qualifier("contactrecordDao")   
	private ContactrecordDao contactrecordDao;

	public ContactrecordDao getContactrecordDao() {
		return contactrecordDao;
	}

	public void setContactrecordDao(ContactrecordDao contactrecordDao) {
		this.contactrecordDao = contactrecordDao;
	}
	
}
