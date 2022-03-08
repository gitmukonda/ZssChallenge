package com.example.demoMysqltutorial.model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Purchase {
	// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
	// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
	/* ObjectMapper om = new ObjectMapper();
	Root root = om.readValue(myJsonString, Root.class); */
	public static class Card{
	    public String id;
	    public String expiry;
	}

	public static class AdditionalData{
	    @JsonProperty("SampleKey") 
	    public String sampleKey;
	}

	public static class Root{
	    public String type;
	    public String extendedType;
	    public double amount;
	    public Date created;
	    public Card card;
	    public String reference;
	    public String narration;
	    public AdditionalData additionalData;
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getExtendedType() {
			return extendedType;
		}
		public void setExtendedType(String extendedType) {
			this.extendedType = extendedType;
		}
		public double getAmount() {
			return amount;
		}
		public void setAmount(double amount) {
			this.amount = amount;
		}
		public Date getCreated() {
			return created;
		}
		public void setCreated(Date created) {
			this.created = created;
		}
		public Card getCard() {
			return card;
		}
		public void setCard(Card card) {
			this.card = card;
		}
		public String getReference() {
			return reference;
		}
		public void setReference(String reference) {
			this.reference = reference;
		}
		public String getNarration() {
			return narration;
		}
		public void setNarration(String narration) {
			this.narration = narration;
		}
		public AdditionalData getAdditionalData() {
			return additionalData;
		}
		public void setAdditionalData(AdditionalData additionalData) {
			this.additionalData = additionalData;
		}
	}

}
