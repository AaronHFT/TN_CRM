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
//客户服务表
@Entity
@Table(name="tn_crm_customerserve")
public class Customerserve implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private Integer id;//服务编号
    private Datadictionary type;//服务类型
    private String summary;//概要
    private Customerinfo customerinfo;//关联客户信息
    private String statu;//状态
    private String request;//服务请求
    private Manager cman;//关联创建人
    private Date ctime;//创建时间
    private String deal;//服务处理
    private Manager dealman;//关联处理人
    private Date dealtime;//处理时间
    private String result;//处理结果
    private Datadictionary csi;//服务满意度
    private Manager manager;//关联客户经理
    private Date dtime;//分配时间
    
    @Id
    @Column(name="tn_crm_cs_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="tn_crm_cs_type")
	public Datadictionary getType() {
		return type;
	}
	public void setType(Datadictionary type) {
		this.type = type;
	}
	@Column(name="tn_crm_cs_summary")
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="tn_crm_cs_ci_id")
	public Customerinfo getCustomerinfo() {
		return customerinfo;
	}
	public void setCustomerinfo(Customerinfo customerinfo) {
		this.customerinfo = customerinfo;
	}
	@Column(name="tn_crm_cs_statu")
	public String getStatu() {
		return statu;
	}
	public void setStatu(String statu) {
		this.statu = statu;
	}
	@Column(name="tn_crm_cs_request")
	public String getRequest() {
		return request;
	}
	public void setRequest(String request) {
		this.request = request;
	}
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="tn_crm_cs_cman")
	public Manager getCman() {
		return cman;
	}
	public void setCman(Manager cman) {
		this.cman = cman;
	}
	
	@Column(name="tn_crm_cs_ctime")
	public Date getCtime() {
		return ctime;
	}
	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}
	@Column(name="tn_crm_cs_deal")
	public String getDeal() {
		return deal;
	}
	public void setDeal(String deal) {
		this.deal = deal;
	}
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="tn_crm_cs_dealman")
	public Manager getDealman() {
		return dealman;
	}
	public void setDealman(Manager dealman) {
		this.dealman = dealman;
	}
	@Column(name="tn_crm_cs_dealtime")
	public Date getDealtime() {
		return dealtime;
	}
	public void setDealtime(Date dealtime) {
		this.dealtime = dealtime;
	}
	@Column(name="tn_crm_cs_result")
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="tn_crm_cs_CSI")
	public Datadictionary getCsi() {
		return csi;
	}
	public void setCsi(Datadictionary csi) {
		this.csi = csi;
	}
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="tn_crm_cs_manager_id")
	public Manager getManager() {
		return manager;
	}
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	@Column(name="tn_crm_cs_dtime")
	public Date getDtime() {
		return dtime;
	}
	public void setDtime(Date dtime) {
		this.dtime = dtime;
	}
  
}
