package com.example.demoMysqltutorial.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="category")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="category_code")
	private String category_code;
	
	@Column(name="categorytitle")
	private String categorytitle;
	
	@Column(name="category_description")
	private String category_description;

	@Column(name="created_by")
	private String created_by;
	
	@Column(name="created_date")
	private Date created_date;

	
	public Category() {
		super();
	}
	
	public Category(long id, String category_code, String categorytitle, String category_description,String created_by, Date created_date) {
		super();
		this.id = id;
		this.category_code = category_code;
		this.categorytitle = categorytitle;
		this.category_description = category_description;
		this.created_by = created_by;
		this.created_date = created_date;
		
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCategory_code() {
		return category_code;
	}
	public void setCategory_code(String category_code) {
		this.category_code = category_code;
	}
	public String getCategorytitle() {
		return categorytitle;
	}
	public void setCategorytitle(String categorytitle) {
		this.categorytitle = categorytitle;
	}
	public String getCategory_description() {
		return category_description;
	}
	public void setCategory_description(String category_description) {
		this.category_description = category_description;
	}
	
	public String getCreated_by() {
		return created_by;
	}
	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}
	
	public Date getCreated_date() {
		return created_date;
	}
	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

}
