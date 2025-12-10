package com.ecommerce.ecommerce.dto;

public class CartDto {

	private long id;
	private ProductDto product;
	private int quantity;

	public CartDto() {
	}

	public CartDto(long id, ProductDto product, int quantity) {
		this.id = id;
		this.product = product;
		this.quantity = quantity;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ProductDto getProduct() {
		return product;
	}

	public void setProduct(ProductDto product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
