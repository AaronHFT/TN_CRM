package org.java.service;

import java.util.List;

import org.java.entity.Datadictionary;

public interface DatadictionaryService {
       public List<Datadictionary> findServiceType();
       
       public List<Datadictionary> findByTypes(String msg);
}
