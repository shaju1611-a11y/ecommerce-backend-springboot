package com.ecommerce.ecommerce.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;

@Entity
@Table(name="orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private double totalAmount;

	@OneToMany(mappedBy="order", cascade=CascadeType.ALL, orphanRemoval=true)
	private List<Cart> cartItems;


	public Order() {
	}

	public Order(double totalAmount, List<Cart> cartItems) {
		this.totalAmount = totalAmount;
		this.cartItems = cartItems;
	}

	public Order(long id, double totalAmount, List<Cart> cartItems) {
		this.id = id;
		this.totalAmount = totalAmount;
		this.cartItems = cartItems;
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

	public List<Cart> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<Cart> cartItems) {
		this.cartItems = cartItems;
	}

}
