package com.ecommerce.ecommerce.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.ecommerce.dto.OrderDto;
import com.ecommerce.ecommerce.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	private final OrderService orderService;

	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}

	@PostMapping
	public ResponseEntity<OrderDto> placeOrder() {
		OrderDto order = orderService.placeOrder();
		return ResponseEntity.status(HttpStatus.CREATED).body(order);

	}

	@GetMapping
	public ResponseEntity<List<OrderDto>> findAllOrder() {
		List<OrderDto> orders = orderService.findAllOrders();
		return ResponseEntity.ok(orders);
	}
}
