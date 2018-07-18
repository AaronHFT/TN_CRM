package org.java.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//客户交往记录
@Entity
@Table(name="tn_crm_contactrecord")
public class Contactrecord implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    
	private Integer id;//记录编号
	private Customerinfo customerinfo;//客户信息对象
	private Date date;//交往时间
	private String address;//交往地点
	private String summary;//交往概要
	private String remark;//交往备注
	private String detail;//交往详情
	private Integer isDel;//是否删除
	
	@Id
	@Column(name="tn_crm_cr_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="tn_crm_cr_ci_id")
	public Customerinfo getCustomerinfo() {
		return customerinfo;
	}
	public void setCustomerinfo(Customerinfo customerinfo) {
		this.customerinfo = customerinfo;
	}
	
	@Column(name="tn_crm_cr_date")
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	@Column(name="tn_crm_cr_address")
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Column(name="tn_crm_cr_summary")
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	@Column(name="tn_crm_cr_remark")
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Column(name="tn_crm_cr_detail")
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	@Column(name="tn_crm_cr_isDel")
	public Integer getIsDel() {
		return isDel;
	}
	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}
	
	
}
