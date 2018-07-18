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

//客户订单表
@Entity
@Table(name="tn_crm_order")
public class Order implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    
	private Integer id;//订单编号
	private Customerinfo customerinfo;//关联客户信息
	private Date createtime;//创建日期
	private Double sum;//总金额
	private String statu;//订单状态
	
	private Set<Goodsorder> goodsorders=new HashSet<Goodsorder>();//关联订单详情集合
	
	@Id
	@Column(name="tn_crm_order_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="tn_crm_order_ci_id")
	public Customerinfo getCustomerinfo() {
		return customerinfo;
	}
	public void setCustomerinfo(Customerinfo customerinfo) {
		this.customerinfo = customerinfo;
	}
	@Column(name="tn_crm_order_ct")
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	@Column(name="tn_crm_order_sum")
	public Double getSum() {
		return sum;
	}
	public void setSum(Double sum) {
		this.sum = sum;
	}
	@Column(name="tn_crm_order_status")
	public String getStatu() {
		return statu;
	}
	public void setStatu(String statu) {
		this.statu = statu;
	}
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="order",fetch=FetchType.EAGER)
	public Set<Goodsorder> getGoodsorders() {
		return goodsorders;
	}
	public void setGoodsorders(Set<Goodsorder> goodsorders) {
		this.goodsorders = goodsorders;
	}
	
}
