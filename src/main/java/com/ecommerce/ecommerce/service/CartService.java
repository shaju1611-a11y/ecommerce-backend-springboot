package com.ecommerce.ecommerce.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecommerce.ecommerce.dto.CartDto;
import com.ecommerce.ecommerce.entity.Cart;
import com.ecommerce.ecommerce.entity.Product;
import com.ecommerce.ecommerce.exception.CartItemNotFoundException;
import com.ecommerce.ecommerce.exception.OutOfStockException;
import com.ecommerce.ecommerce.exception.ProductNotFoundException;
import com.ecommerce.ecommerce.mapper.DTOConverter;
import com.ecommerce.ecommerce.repository.CartRepository;
import com.ecommerce.ecommerce.repository.ProductRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CartService {	

	private final ProductRepository productRepo;
	private final CartRepository cartRepo;

	public CartService(ProductRepository productRepo, CartRepository cartRepo) {
		this.productRepo = productRepo;
		this.cartRepo = cartRepo;
	}

	public CartDto addToCart(Long productId, int quantity) {
		Product product = productRepo.findById(productId).orElseThrow(() -> new ProductNotFoundException("product not found with id="+productId));

		if (product.getStock() < quantity) {
			throw new OutOfStockException("not enough stock the product with id="+productId);
		}

		Cart cart = new Cart(product, quantity);
		Cart savedCart = cartRepo.save(cart);

		return DTOConverter.toCartDto(savedCart);

	}

	public List<CartDto> getCartItems() {
		List<Cart> cartItems = cartRepo.findAll();
		return cartItems.stream() 
					    .map(DTOConverter::toCartDto) 
					    .toList();
	}

	public boolean clearCartItem(Long id) {

	    Cart cart = cartRepo.findById(id)
	            .orElseThrow(() -> new CartItemNotFoundException("there are no cart items with id " + id));

	    cart.setOrder(null);

	    cartRepo.delete(cart);
	    return true;
	}

	
	public void clearCart() {
		cartRepo.deleteAll();
	}
}
