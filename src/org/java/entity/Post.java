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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
//职位表
@Entity
@Table(name="tn_crm_post")
public class Post implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;//职位编号
	private String name;//职位名称(系统管理员，销售主管，客户经理，高管)	
	private Set<Manager> managers=new HashSet<Manager>();//职位相应的用户信息
	private Set<Function> functions=new HashSet<Function>();//职位相应的功能信息
	@Id
	@Column(name="tn_crm_post_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="tn_crm_post_name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@OneToMany(cascade=CascadeType.ALL,mappedBy="post",fetch=FetchType.EAGER)
	public Set<Manager> getManagers() {
		return managers;
	}
	public void setManagers(Set<Manager> managers) {
		this.managers = managers;
	}
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(
				name="tn_crm_relation_fd",
				joinColumns={@JoinColumn(name="tn_crm_post_id")},
				inverseJoinColumns={@JoinColumn(name="tn_crm_function_id")}
			)
	public Set<Function> getFunctions() {
		return functions;
	}
	public void setFunctions(Set<Function> functions) {
		this.functions = functions;
	}
	

}
