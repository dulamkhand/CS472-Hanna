package edu.mum.cs.cs472.w3d3.model;

import java.io.Serializable;

public class ContactMessage implements Serializable {
	private static final long serialVersionUID = -2128241152803480784L;
	private int contactMessageId;
	private String customerName;
	private String gender;
	private String category;
	private String message;
	private String currentDate;

	public ContactMessage() {
		super();
	}

	public ContactMessage(int contactMessageId, String customerName, String gender, String category, String message, String currentDate) {
		super();
		this.contactMessageId = contactMessageId;
		this.customerName = customerName;
		this.gender = gender;
		this.category = category;
		this.message = message;
		this.currentDate = currentDate;
	}

	public int getContactMessageId() {
		return contactMessageId;
	}

	public void setContactMessageId(int contactMessageId) {
		this.contactMessageId = contactMessageId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(String currentDate) {
		this.currentDate = currentDate;
	}
	
}
