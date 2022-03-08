package com.example.demoMysqltutorial.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="PuchaseResponse")
public class PurchaseResponse {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;


	@Column(name="updated")
	    private Date updated;
	
	@Column(name="responseCode")
	    private String responseCode;
	
	@Column(name="responseDescription")
	    private String responseDescription;
	
	@Column(name="reference")
	    private String reference;
	
	@Column(name="debitReference")
	    private String debitReference;
	
		public PurchaseResponse() {
			super();
		}
		
		public PurchaseResponse(Date updated, String responseCode, String responseDescription, String reference, String debitReference, long id) {
			super();
			this.id = id;
			this.updated = updated;
			this.responseCode = responseCode;
			this.responseDescription = responseDescription;
			this.reference = reference;
			this.debitReference = debitReference;
		}
		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

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

		public String getReference() {
			return reference;
		}

		public void setReference(String reference) {
			this.reference = reference;
		}

		public String getDebitReference() {
			return debitReference;
		}

		public void setDebitReference(String debitReference) {
			this.debitReference = debitReference;
		}
}
