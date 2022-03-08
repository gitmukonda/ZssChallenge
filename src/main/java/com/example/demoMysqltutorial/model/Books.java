package com.example.demoMysqltutorial.model;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="books")
public class Books {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="description")
	private String description;
	
	@Column(name="price")
	private String price;
	
	@Column(name="purchase_status")
	private String purchase_status;
	
	@Column(name="created_by")
	private String created_by;
	
	@Column(name="created_date")
	private Date created_date;
	
	@Column(name="category")
	private long category;
	
	@Column(name="purchasereference")
	private String purchasereference;
	 //
	@Column(name="updated")
	private Date updated;
	
	@Column(name="responseCode")
	private String responseCode;
	
	@Column(name="responseDescription")
	private String responseDescription;
	
	@Column(name="debitReference")
	private String debitReference;
	
	
	public Books() {
		super();
	}
	
	public Books(long id, String title, String description, String price,String purchase_status, String created_by, Date created_date, long category, String purchasereference
			, Date updated, String responseCode, String responseDescription, String debitReference) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.price = price;
		this.purchase_status = purchase_status;
		this.created_by = created_by;
		this.created_date = created_date;
		this.category = category;
		this.purchasereference = purchasereference;
		this.updated = updated;
		this.responseCode = responseCode;
		this.responseDescription = responseDescription;
		this.debitReference = debitReference;
	}
	public Books(EntityManager em) {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	public String getPurchase_status() {
		return purchase_status;
	}
	public void setPurchase_status(String purchase_status) {
		this.purchase_status = purchase_status;
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

	public long getCategory() {
		return category;
	}
	public void setCategory(long category) {
		this.category = category;
	}
	public String getPurchasereference() {
		return purchasereference;
	}
	public void setPurchasereference(String purchasereference) {
		this.purchasereference = purchasereference;
	}
	//////



		
	public Date getUpdated() {
		return updated;
	}
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public String getResponseDescription() {
		return responseDescription;
	}
	public void setResponseDescription(String responseDescription) {
		this.responseDescription = responseDescription;
	}
	public String getDebitReference() {
		return debitReference;
	}
	public void setDebitReference(String debitReference) {
		this.debitReference = debitReference;
	}
	
	

}
