package com.codeyatra.springbatch.dto;

/**
 * 
 * @author codeYatra
 *
 */

public class Product {

	private String productName;
	private String productDescription;
	private double price;

	public Product() {
		super();
	}

	public Product(String productName, String productDescription, double price) {
		super();
		this.productName = productName;
		this.productDescription = productDescription;
		this.price = price;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public String getProductDescription() {
		return productDescription;
	}
	
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [productName=" + productName + ", productDescription=" + productDescription + ", price=" + price
				+ "]";
	}
}