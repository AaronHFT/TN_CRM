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

//货品库存表
@Entity
@Table(name="tn_crm_repertory")
public class Repertory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    
	private Integer id;//货品库存编号
	private Goods goods;//关联货品对象
	private String name;//仓库名字
	private String site;//货品位
	private Integer num;//库存件数
	private String remark;//备注
	
	@Id
	@Column(name="tn_crm_repertory_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="tn_crm_repertory_goods_id")
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	
	@Column(name="tn_crm_repertory_name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="tn_crm_repertory_site")
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	
	@Column(name="tn_crm_repertory_num")
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	
	@Column(name="tn_crm_repertory_remark")
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
