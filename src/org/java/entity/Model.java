package org.java.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
//模块表
@Entity
@Table(name="tn_crm_model")
public class Model implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
    private Integer id;//编号
    private String name;//模块名(营销管理、客户管理、服务管理、统计报表、基础数据和权限管理)
    private Set<Function> functions=new HashSet<Function>();//相应模块对应的功能对象
    
    @Id
    @Column(name="tn_crm_model_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="tn_crm_model_name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@OneToMany(cascade=CascadeType.ALL,mappedBy="model",fetch=FetchType.EAGER)
	public Set<Function> getFunctions() {
		return functions;
	}
	public void setFunctions(Set<Function> functions) {
		this.functions = functions;
	}

    
    
}
