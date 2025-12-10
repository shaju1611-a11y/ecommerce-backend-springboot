package com.ecommerce.ecommerce.mapper;

import com.ecommerce.ecommerce.dto.CartDto;
import com.ecommerce.ecommerce.dto.OrderDto;
import com.ecommerce.ecommerce.dto.ProductDto;
import com.ecommerce.ecommerce.entity.Cart;
import com.ecommerce.ecommerce.entity.Order;
import com.ecommerce.ecommerce.entity.Product;

public class DTOConverter {

	public static ProductDto toProductDto(Product product) {
		return new ProductDto(
				product.getId(),
				product.getName(),
				product.getPrice(),
				product.getStock());
	}

	public static CartDto toCartDto(Cart cart) {
		return new CartDto(
				cart.getId(),
				toProductDto(cart.getProduct()),
				cart.getQuantity());
	}
	
	public static OrderDto toOrderDto(Order order) {
		return new OrderDto(
				order.getId(),
				order.getTotalAmount(),
				order.getCartItems()
					 .stream()
					 .map(DTOConverter::toCartDto)
					 .toList());
	}
}
