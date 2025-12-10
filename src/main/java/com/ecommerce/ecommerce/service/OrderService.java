package com.ecommerce.ecommerce.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.ecommerce.ecommerce.dto.OrderDto;
import com.ecommerce.ecommerce.entity.Cart;
import com.ecommerce.ecommerce.entity.Order;
import com.ecommerce.ecommerce.entity.Product;
import com.ecommerce.ecommerce.exception.CartEmptyException;
import com.ecommerce.ecommerce.exception.OutOfStockException;
import com.ecommerce.ecommerce.mapper.DTOConverter;
import com.ecommerce.ecommerce.repository.CartRepository;
import com.ecommerce.ecommerce.repository.OrderRepository;
import com.ecommerce.ecommerce.repository.ProductRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class OrderService {

	private final ProductRepository productRepo;
	private final CartRepository cartRepo;
	private final OrderRepository orderRepo;

	public OrderService(ProductRepository productRepo, CartRepository cartRepo, OrderRepository orderRepo) {
		this.productRepo = productRepo;
		this.cartRepo = cartRepo;
		this.orderRepo = orderRepo;
	}

	
	public OrderDto placeOrder() {

		List<Cart> cartItems = cartRepo.findAll();

		if (cartItems.isEmpty()) {
			throw new CartEmptyException("cart is empty");
		}
		
        for (Cart cart : cartItems) {
            Product product = cart.getProduct();
            if (product.getStock() < cart.getQuantity()) {
                throw new OutOfStockException("Not enough stock for product: " + product.getName());
            }
        }

        for (Cart cart : cartItems) {
            Product product = cart.getProduct();
            product.setStock(product.getStock() - cart.getQuantity());
            productRepo.save(product);
        }



		double total = cartItems.stream()
								.mapToDouble(c->c.getProduct().getPrice()*c.getQuantity()) 
								.sum();
		
		Order order = new Order(total, cartItems);
		cartItems.forEach(cart->cart.setOrder(order));
		Order saveOrder = orderRepo.save(order);
		
		cartRepo.deleteAll();

		return DTOConverter.toOrderDto(saveOrder);
	}

	public List<OrderDto> findAllOrders() {
		List<Order> orders = orderRepo.findAll();
		return orders.stream()
					 .map(DTOConverter::toOrderDto) 
					 .toList();
	}
}
