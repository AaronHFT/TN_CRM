package org.java.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
//功能表
@Entity
@Table(name="tn_crm_function")
public class Function implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;//功能编号
	private String name;//功能名称
	private String url;//跳转地址
	private Model model;//功能相应的模块	
	private Set<Post> posts=new HashSet<Post>();//功能相应的职位信息
    @Id
    @Column(name="tn_crm_function_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
    @Column(name="tn_crm_function_name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    @Column(name="tn_crm_function_url")
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="tn_crm_model_id")
	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}
	@ManyToMany(mappedBy="functions")
	public Set<Post> getPosts() {
		return posts;
	}

	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}

	
}
