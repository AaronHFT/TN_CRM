package org.java.service;

import java.io.Serializable;
import java.util.List;

import org.java.entity.Customerserve;

public interface CustomerserveService {
	public void addCS(Customerserve cs);
	
	public void updateCS(Customerserve cs);
	
	public List<Customerserve> findDivids();
	
	public List<Customerserve> findList(String msg);
	
	public Customerserve findByCSId(Serializable id);
}
