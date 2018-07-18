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

//货品订单详情
@Entity
@Table(name="tn_crm_goodsorder")
public class Goodsorder implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    
	private Integer id;//详情编号
	private Order order;//对应订单对象
	private Goods goods;//对应货品对象
	private Integer num;//货品数量
	private Double sum;//小计金额
	@Id
	@Column(name="tn_crm_go_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="tn_crm_go_order_id")
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="tn_crm_go_goods_id")
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	@Column(name="tn_crm_go_num")
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	@Column(name="tn_crm_go_sum")
	public Double getSum() {
		return sum;
	}
	public void setSum(Double sum) {
		this.sum = sum;
	}
	
	
}
