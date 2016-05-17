package models;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class Order {
	
	private Skateboard skateboard;
	private String customerName;
	private String customerAddress;
	private String customerPhone;
	private String customerEmail;
	private String customerComment;
	
	public Order() {
	}

	public Skateboard getSkateboard() {
		return skateboard;
	}

	public void setSkateboard(Skateboard skateboard) {
		this.skateboard = skateboard;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerComment() {
		return customerComment;
	}

	public void setCustomerComment(String customerComment) {
		this.customerComment = customerComment;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

}
