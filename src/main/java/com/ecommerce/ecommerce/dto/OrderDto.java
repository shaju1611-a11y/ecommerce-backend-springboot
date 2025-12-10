package com.ecommerce.ecommerce.dto;

import java.util.List;

public class OrderDto {

	private long id;
	private double totalAmount;
	private List<CartDto> cartItems;
	
	public OrderDto() {}
	
	public OrderDto(double totalAmount, List<CartDto> cartItems) {
		this.totalAmount=totalAmount;
		this.cartItems=cartItems;
	}
	
	public OrderDto(long id,double totalAmount, List<CartDto> cartItems) {
		this.id=id;
		this.totalAmount=totalAmount;
		this.cartItems=cartItems;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public List<CartDto> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartDto> cartItems) {
		this.cartItems = cartItems;
	}

}
