package org.java.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//联系人
@Entity
@Table(name="tn_crm_relationpeople")
public class Relationpeople implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;//联系人编号
	private Customerinfo customerinfo;//客户信息对象
	private String name;//姓名
	private String gender;//性别
	private String post;//职位
	private String tel;//办公电话
	private String phone;//手机
	private String remark;//备注
	private Integer isDel;//是否删除
	@Id
	@Column(name="tn_crm_rp_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="tn_crm_rp_ci_id")
	public Customerinfo getCustomerinfo() {
		return customerinfo;
	}
	public void setCustomerinfo(Customerinfo customerinfo) {
		this.customerinfo = customerinfo;
	}
	
	@Column(name="tn_crm_rp_name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="tn_crm_rp_gender")
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Column(name="tn_crm_rp_post")
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	@Column(name="tn_crm_rp_tel")
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	@Column(name="tn_crm_rp_phone")
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Column(name="tn_crm_rp_remark")
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Column(name="tn_crm_rp_isDel")
	public Integer getIsDel() {
		return isDel;
	}
	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}
	
	

}
