package org.java.service;

import java.io.Serializable;
import java.util.List;

import org.java.entity.Manager;

public interface ManagerService {
        public Manager findByLogin(String account,String pwd);
        
        public List<Manager> findAllManager();
        
        public Manager findByDividId(Serializable id);
}
