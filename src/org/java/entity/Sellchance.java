package org.java.entity;

import java.io.Serializable;
import java.util.Date;
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

//销售机会表
@Entity
@Table(name="tn_crm_sellchance")
public class Sellchance implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;//销售机会编号
	private String src;//机会来源
	private String name;//客户名称
	private Integer chance;//成功几率
	private String summary;//概要
	private String relationpeople;//联系人
	private String rphone;//联系人电话
	private String desc;//机会描述
	private Manager cman;//关联管理员表创建人
	private Date createTime;//创建时间
	private String statu;//销售机会状态
	private Manager manager;//客户经理对象
	private Date ptime;//指派时间
	private Integer isDel;//是否删除
	
	private Set<Developmentplan> developmentplan=new HashSet<Developmentplan>();//关联开发计划集合
	
	@Id
	@Column(name="tn_crm_sc_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="tn_crm_sc_src")
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	@Column(name="tn_crm_sc_name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="tn_crm_sc_chance")
	public Integer getChance() {
		return chance;
	}
	public void setChance(Integer chance) {
		this.chance = chance;
	}
	@Column(name="tn_crm_sc_summary")
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	@Column(name="tn_crm_sc_rp")
	public String getRelationpeople() {
		return relationpeople;
	}
	public void setRelationpeople(String relationpeople) {
		this.relationpeople = relationpeople;
	}
	@Column(name="tn_crm_sc_rphone")
	public String getRphone() {
		return rphone;
	}
	public void setRphone(String rphone) {
		this.rphone = rphone;
	}
	@Column(name="tn_crm_sc_desc")
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="tn_crm_sc_manager_cid")
	public Manager getCman() {
		return cman;
	}
	public void setCman(Manager cman) {
		this.cman = cman;
	}
	@Column(name="tn_crm_sc_ct")
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Column(name="tn_crm_sc_statu")
	public String getStatu() {
		return statu;
	}
	public void setStatu(String statu) {
		this.statu = statu;
	}
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="tn_crm_sc_mananger_pid")
	public Manager getManager() {
		return manager;
	}
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	@Column(name="tn_crm_sc_pt")
	public Date getPtime() {
		return ptime;
	}
	public void setPtime(Date ptime) {
		this.ptime = ptime;
	}
	@Column(name="tn_crm_sc_isDel")
	public Integer getIsDel() {
		return isDel;
	}
	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}
	@OneToMany(cascade=CascadeType.ALL,mappedBy="sellchance",fetch=FetchType.EAGER)
	public Set<Developmentplan> getDevelopmentplan() {
		return developmentplan;
	}
	public void setDevelopmentplan(Set<Developmentplan> developmentplan) {
		this.developmentplan = developmentplan;
	}
	
	

}
