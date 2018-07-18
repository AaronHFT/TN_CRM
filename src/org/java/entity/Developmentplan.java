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

//开发计划表
@Entity
@Table(name="tn_crm_developmentplan")
public class Developmentplan implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;//开发计划编号
	private Sellchance sellchance;//关联机会
	private String context;//计划项内容
	private Date createtime;//创建时间
	private String result;//执行效果
	private Integer isDel;//是否删除
	@Id
	@Column(name="tn_crm_dp_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="tn_crm_dp_scid")
	public Sellchance getSellchance() {
		return sellchance;
	}
	public void setSellchance(Sellchance sellchance) {
		this.sellchance = sellchance;
	}
	@Column(name="tn_crm_dp_context")
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	@Column(name="tn_crm_dp_ct")
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	@Column(name="tn_crm_dp_result")
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	@Column(name="tn_crm_dp_isDel")
	public Integer getIsDel() {
		return isDel;
	}
	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}
	
	
}
