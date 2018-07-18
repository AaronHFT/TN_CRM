package org.java.service.impl;

import org.java.dao.RelationpeopleDao;
import org.java.service.RelationpeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
@Service("relationpeopleService")
public class RelationpeopleServiceImpl implements RelationpeopleService {
	@Autowired
    @Qualifier("relationpeopleDao")
	private RelationpeopleDao relationpeopleDao;

	public RelationpeopleDao getRelationpeopleDao() {
		return relationpeopleDao;
	}

	public void setRelationpeopleDao(RelationpeopleDao relationpeopleDao) {
		this.relationpeopleDao = relationpeopleDao;
	}
     
}
