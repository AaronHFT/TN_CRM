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

//客户信息
@Entity
@Table(name="tn_crm_customerinfo")
public class Customerinfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    
	private Integer id;//客户编号
	private String name;//客户名称
	private Datadictionary area;//地区
	private Manager manager;//客户经理
	private Datadictionary level;//客户等级
	private Datadictionary satisfaction;//客户满意度
	private Datadictionary credit;//客户信用度
	private String address;//客户地址
    private String mail;//邮政编码
    private String phone;//电话
    private String fax;//传真
    private String url;//网址
    private String regist;//营业执照注册号
    private String legalman;//法人
    private Double fund;//注册资金
    private Double balance;//年营业额
    private String bank;//开户银行
    private String bankId;//银行账号
    private String losttime;//确认流失时间
    private String measure;//暂缓措施
    private String statu;//客户状态
    
    private Set<Customerserve> customerserve=new HashSet<Customerserve>();//客户服务关联的客户信息
    private Set<Order> orders=new HashSet<Order>();//订单信息
    private Set<Contactrecord> contactrecord=new HashSet<Contactrecord>();//客户交往记录
    private Set<Relationpeople> relationpeople=new HashSet<Relationpeople>();//联系人
    
    @Id
    @Column(name="tn_crm_ci_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="tn_crm_ci_name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="tn_crm_ci_dd_area")
	public Datadictionary getArea() {
		return area;
	}
	public void setArea(Datadictionary area) {
		this.area = area;
	}
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="tn_crm_ci_manager_id")
	public Manager getManager() {
		return manager;
	}
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="tn_crm_ci_dd_level")
	public Datadictionary getLevel() {
		return level;
	}
	public void setLevel(Datadictionary level) {
		this.level = level;
	}
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="tn_crm_ci_dd_satisfaction")
	public Datadictionary getSatisfaction() {
		return satisfaction;
	}
	public void setSatisfaction(Datadictionary satisfaction) {
		this.satisfaction = satisfaction;
	}
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="tn_crm_ci_dd_credit")
	public Datadictionary getCredit() {
		return credit;
	}
	public void setCredit(Datadictionary credit) {
		this.credit = credit;
	}
	
	@Column(name="tn_crm_ci_address")
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Column(name="tn_crm_ci_mail")
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	@Column(name="tn_crm_ci_phone")
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Column(name="tn_crm_ci_fax")
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	
	@Column(name="tn_crm_ci_url")
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	@Column(name="tn_crm_ci_regist")
	public String getRegist() {
		return regist;
	}
	public void setRegist(String regist) {
		this.regist = regist;
	}
	
	@Column(name="tn_crm_ci_legalman")
	public String getLegalman() {
		return legalman;
	}
	public void setLegalman(String legalman) {
		this.legalman = legalman;
	}
	
	@Column(name="tn_crm_ci_fund")
	public Double getFund() {
		return fund;
	}
	public void setFund(Double fund) {
		this.fund = fund;
	}
	
	@Column(name="tn_crm_ci_balance")
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	
	@Column(name="tn_crm_ci_bank")
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	
	@Column(name="tn_crm_ci_bankId")
	public String getBankId() {
		return bankId;
	}
	public void setBankId(String bankId) {
		this.bankId = bankId;
	}
	
	@Column(name="tn_crm_ci_losttime")
	public String getLosttime() {
		return losttime;
	}
	public void setLosttime(String losttime) {
		this.losttime = losttime;
	}
	
	@Column(name="tn_crm_ci_measure")
	public String getMeasure() {
		return measure;
	}
	public void setMeasure(String measure) {
		this.measure = measure;
	}
	
	@Column(name="tn_crm_ci_statu")
	public String getStatu() {
		return statu;
	}
	public void setStatu(String statu) {
		this.statu = statu;
	}
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="customerinfo",fetch=FetchType.EAGER)
	public Set<Customerserve> getCustomerserve() {
		return customerserve;
	}
	public void setCustomerserve(Set<Customerserve> customerserve) {
		this.customerserve = customerserve;
	}
	@OneToMany(cascade=CascadeType.ALL,mappedBy="customerinfo",fetch=FetchType.EAGER)
	public Set<Order> getOrders() {
		return orders;
	}
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	@OneToMany(cascade=CascadeType.ALL,mappedBy="customerinfo",fetch=FetchType.EAGER)
	public Set<Contactrecord> getContactrecord() {
		return contactrecord;
	}
	public void setContactrecord(Set<Contactrecord> contactrecord) {
		this.contactrecord = contactrecord;
	}
	@OneToMany(cascade=CascadeType.ALL,mappedBy="customerinfo",fetch=FetchType.EAGER)
	public Set<Relationpeople> getRelationpeople() {
		return relationpeople;
	}
	public void setRelationpeople(Set<Relationpeople> relationpeople) {
		this.relationpeople = relationpeople;
	}
    
}
