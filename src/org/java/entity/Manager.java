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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
//用户表
@Entity
@Table(name="tn_crm_manager")
public class Manager implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;//用户编号
	private String account;//用户账号
	private String pwd;//用户密码
	private String name;//用户姓名
	private String statu;//用户状态
	private Post post;//职位对象
	private Set<Customerinfo> customerinfos=new HashSet<Customerinfo>();//关联客户集合
	private Set<Customerserve> cs_cman=new HashSet<Customerserve>();//关联服务表创建人
	private Set<Customerserve> cs_dealman=new HashSet<Customerserve>();//关联服务表处理人
	private Set<Customerserve> cs_manager=new HashSet<Customerserve>();//关联服务表客户经理
	private Set<Sellchance> sc_cman=new HashSet<Sellchance>();//关联销售机会表创建人
	private Set<Sellchance> sc_manager=new HashSet<Sellchance>();//关联销售机会客户经理
	
	@Id
	@Column(name="tn_crm_manager_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="tn_crm_manager_account")
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	@Column(name="tn_crm_manager_pwd")
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Column(name="tn_crm_manager_name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="tn_crm_manager_statu")
	public String getStatu() {
		return statu;
	}
	public void setStatu(String statu) {
		this.statu = statu;
	}
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="tn_crm_post_id")
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	@OneToMany(cascade=CascadeType.ALL,mappedBy="manager",fetch=FetchType.EAGER)
	public Set<Customerinfo> getCustomerinfos() {
		return customerinfos;
	}
	public void setCustomerinfos(Set<Customerinfo> customerinfos) {
		this.customerinfos = customerinfos;
	}
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="cman",fetch=FetchType.EAGER)
	public Set<Customerserve> getCs_cman() {
		return cs_cman;
	}
	public void setCs_cman(Set<Customerserve> cs_cman) {
		this.cs_cman = cs_cman;
	}
	@OneToMany(cascade=CascadeType.ALL,mappedBy="dealman",fetch=FetchType.EAGER)
	public Set<Customerserve> getCs_dealman() {
		return cs_dealman;
	}
	public void setCs_dealman(Set<Customerserve> cs_dealman) {
		this.cs_dealman = cs_dealman;
	}
	@OneToMany(cascade=CascadeType.ALL,mappedBy="manager",fetch=FetchType.EAGER)
	public Set<Customerserve> getCs_manager() {
		return cs_manager;
	}
	public void setCs_manager(Set<Customerserve> cs_manager) {
		this.cs_manager = cs_manager;
	}
	@OneToMany(cascade=CascadeType.ALL,mappedBy="cman",fetch=FetchType.EAGER)
	public Set<Sellchance> getSc_cman() {
		return sc_cman;
	}
	public void setSc_cman(Set<Sellchance> sc_cman) {
		this.sc_cman = sc_cman;
	}
	@OneToMany(cascade=CascadeType.ALL,mappedBy="manager",fetch=FetchType.EAGER)
	public Set<Sellchance> getSc_manager() {
		return sc_manager;
	}
	public void setSc_manager(Set<Sellchance> sc_manager) {
		this.sc_manager = sc_manager;
	}

	
}
