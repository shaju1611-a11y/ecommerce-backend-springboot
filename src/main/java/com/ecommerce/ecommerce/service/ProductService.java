package com.ecommerce.ecommerce.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecommerce.ecommerce.dto.ProductDto;
import com.ecommerce.ecommerce.entity.Product;
import com.ecommerce.ecommerce.exception.ProductNotFoundException;
import com.ecommerce.ecommerce.mapper.DTOConverter;
import com.ecommerce.ecommerce.repository.ProductRepository;

@Service
public class ProductService {

	private final ProductRepository productRepo;

	public ProductService(ProductRepository productRepo) {
		this.productRepo = productRepo;
	}

	public ProductDto addProduct(Product product) {
		 Product saved=productRepo.save(product);
		 return DTOConverter.toProductDto(saved);
	}

	public List<ProductDto> findAllProducts() {
		 return productRepo.findAll()
				.stream()
				.map(DTOConverter::toProductDto) 
				.toList();
	}

	public boolean deleteProduct(Long id) {
		if(!productRepo.existsById(id)) {
			throw new ProductNotFoundException("product not found with id="+id);
		}
		productRepo.deleteById(id);
		return true;
	}
}
