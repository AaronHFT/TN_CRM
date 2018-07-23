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

//货品表
@Entity
@Table(name="tn_crm_goods")
public class Goods implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private Integer id;//货品编号
    private String name;//货品名称
    private String type;//货品型号
    private String level;//等级批次
    private String unit;//单位
    private Integer price;//商品单价
    private String remark;//备注
    
    private Set<Repertory> repertorys=new HashSet<Repertory>();//相关货品库存的集合
    private Set<Goodsorder> goodsorders=new HashSet<Goodsorder>();//相关货品订单详情
    
    @Id
    @Column(name="tn_crm_goods_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="tn_crm_goods_name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="tn_crm_goods_type")
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@Column(name="tn_crm_goods_level")
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	
	@Column(name="tn_crm_goods_unit")
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}	
	@Column(name="tn_crm_goods_remark")
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Column(name="tn_crm_goods_price")
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="goods",fetch=FetchType.EAGER)
	public Set<Repertory> getRepertorys() {
		return repertorys;
	}
	public void setRepertorys(Set<Repertory> repertorys) {
		this.repertorys = repertorys;
	}
	@OneToMany(cascade=CascadeType.ALL,mappedBy="goods",fetch=FetchType.EAGER)
	public Set<Goodsorder> getGoodsorders() {
		return goodsorders;
	}
	public void setGoodsorders(Set<Goodsorder> goodsorders) {
		this.goodsorders = goodsorders;
	}
    
    
}
