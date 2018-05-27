package com.kingfisher.orderhub.fulfilmentsource.domain;

public class Product {

	private String product_id;
	private String product_description;
	private String product_price;

	public Product() {

	}

	public Product(String product_id, String product_description,
			String product_price) {
		super();
		this.product_id = product_id;
		this.product_description = product_description;
		this.product_price = product_price;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public String getProduct_description() {
		return product_description;
	}

	public void setProduct_description(String product_description) {
		this.product_description = product_description;
	}

	public String getProduct_price() {
		return product_price;
	}

	public void setProduct_price(String product_price) {
		this.product_price = product_price;
	}
}
