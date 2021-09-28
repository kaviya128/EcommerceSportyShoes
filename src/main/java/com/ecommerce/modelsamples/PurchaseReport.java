package com.ecommerce.modelsamples;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class PurchaseReport {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int purchaseId;
	private int userId;
	private String username;
	private int productId;
	private String productName;
	private int quantity;
	private double price;
	private String category;
	
    @Temporal(TemporalType.DATE)
	private Date datePurchasedBy;
	
	public PurchaseReport() {
		super();
	}

	public int getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Date getDatePurchasedBy() {
		return datePurchasedBy;
	}

	public void setDatePurchasedBy(Date datePurchasedBy) {
		this.datePurchasedBy = datePurchasedBy;
	}

	@Override
	public String toString() {
		return "PurchaseReport [purchaseId=" + purchaseId + ", userId=" + userId + ", username=" + username
				+ ", productId=" + productId + ", productName=" + productName + ", quantity=" + quantity + ", price="
				+ price + ", category=" + category + ", datePurchasedBy=" + datePurchasedBy + "]";
	}
	
	
	
	
	

}
