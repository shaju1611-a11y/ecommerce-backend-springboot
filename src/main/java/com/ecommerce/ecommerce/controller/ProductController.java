package com.ecommerce.ecommerce.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.ecommerce.dto.ProductDto;
import com.ecommerce.ecommerce.entity.Product;
import com.ecommerce.ecommerce.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	private final ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@PostMapping
	public ResponseEntity<ProductDto> addProduct(@RequestBody Product product) {
		ProductDto saveProduct = productService.addProduct(product);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveProduct);
	}

	@GetMapping
	public ResponseEntity<List<ProductDto>> findAllProducts() {
		List<ProductDto> allProducts = productService.findAllProducts();
		return ResponseEntity.ok(allProducts);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
		boolean deleted = productService.deleteProduct(id);
		return ResponseEntity.ok("Product deleted successfully");

	}

}
