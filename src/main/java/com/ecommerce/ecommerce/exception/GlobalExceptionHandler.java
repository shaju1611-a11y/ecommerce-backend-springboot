package com.ecommerce.ecommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleProductNotFound(ProductNotFoundException ex) {
		ErrorResponse error = new ErrorResponse("error", ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

	@ExceptionHandler(OutOfStockException.class)
	public ResponseEntity<ErrorResponse> handleOutOfStock(OutOfStockException ex) {
		ErrorResponse error = new ErrorResponse("error", ex.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}

	@ExceptionHandler(CartEmptyException.class)
	public ResponseEntity<ErrorResponse> handleCartEmpty(CartEmptyException ex) {
		ErrorResponse error = new ErrorResponse("error", ex.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}

	@ExceptionHandler(CartItemNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleCartItemNotFound(CartItemNotFoundException ex) {
		ErrorResponse error = new ErrorResponse("error", ex.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
}
