package com.ecommerce.ecommerce.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.ecommerce.dto.CartDto;
import com.ecommerce.ecommerce.entity.Cart;
import com.ecommerce.ecommerce.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {
	private final CartService cartService;

	public CartController(CartService cartService) {
		this.cartService = cartService;
	}

	@PostMapping("/add")
	public ResponseEntity<CartDto> addToCart(@RequestParam Long productId, @RequestParam int quantity) {
		CartDto dto = cartService.addToCart(productId, quantity);
		return ResponseEntity.status(HttpStatus.CREATED).body(dto);
	}

	@GetMapping
	public ResponseEntity<List<CartDto>> getCartItems() {
		List<CartDto> cartItems = cartService.getCartItems();

		return ResponseEntity.ok(cartItems);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> clearCartItem(@PathVariable Long id) {
		boolean deleted = cartService.clearCartItem(id);
		return ResponseEntity.ok("Cart item deleted successfully");

	}

	@DeleteMapping
	public ResponseEntity<String> clearCart() {
		cartService.clearCart();
		return ResponseEntity.ok("All cart items deleted successfully");
	}

}
