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

//数据字典
@Entity
@Table(name="tn_crm_datadictionary")
public class Datadictionary implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;//数据字典编号
	private String type;//类别
	private String context;//条目
	private String value;//值
	private String isEdit;//是否可编辑
	
	private Set<Customerinfo> cf_area=new HashSet<Customerinfo>();//地区
	private Set<Customerinfo> cf_level=new HashSet<Customerinfo>();//客户等级
	private Set<Customerinfo> cf_satisfaction=new HashSet<Customerinfo>();//客户满意度
	private Set<Customerinfo> cf_credit=new HashSet<Customerinfo>();//客户信任度
	private Set<Customerserve> cs_type=new HashSet<Customerserve>();//服务类型
	private Set<Customerserve> cs_csi=new HashSet<Customerserve>();//服务满意度
	@Id
	@Column(name="tn_crm_dd_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="tn_crm_dd_type")
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@Column(name="tn_crm_dd_context")
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	@Column(name="tn_crm_dd_value")
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	@Column(name="tn_crm_dd_isEdit")
	public String getIsEdit() {
		return isEdit;
	}
	public void setIsEdit(String isEdit) {
		this.isEdit = isEdit;
	}
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="area",fetch=FetchType.EAGER)
	public Set<Customerinfo> getCf_area() {
		return cf_area;
	}
	public void setCf_area(Set<Customerinfo> cf_area) {
		this.cf_area = cf_area;
	}
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="level",fetch=FetchType.EAGER)
	public Set<Customerinfo> getCf_level() {
		return cf_level;
	}
	public void setCf_level(Set<Customerinfo> cf_level) {
		this.cf_level = cf_level;
	}
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="satisfaction",fetch=FetchType.EAGER)
	public Set<Customerinfo> getCf_satisfaction() {
		return cf_satisfaction;
	}
	public void setCf_satisfaction(Set<Customerinfo> cf_satisfaction) {
		this.cf_satisfaction = cf_satisfaction;
	}
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="credit",fetch=FetchType.EAGER)
	public Set<Customerinfo> getCf_credit() {
		return cf_credit;
	}
	public void setCf_credit(Set<Customerinfo> cf_credit) {
		this.cf_credit = cf_credit;
	}
	@OneToMany(cascade=CascadeType.ALL,mappedBy="type",fetch=FetchType.EAGER)
	public Set<Customerserve> getCs_type() {
		return cs_type;
	}
	public void setCs_type(Set<Customerserve> cs_type) {
		this.cs_type = cs_type;
	}
	@OneToMany(cascade=CascadeType.ALL,mappedBy="csi",fetch=FetchType.EAGER)
	public Set<Customerserve> getCs_csi() {
		return cs_csi;
	}
	public void setCs_csi(Set<Customerserve> cs_csi) {
		this.cs_csi = cs_csi;
	}
	
	

}
