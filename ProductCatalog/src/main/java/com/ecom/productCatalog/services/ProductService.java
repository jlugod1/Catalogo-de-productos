package com.ecom.productCatalog.services;
import org.springframework.stereotype.Service;
import java.util.List;

import com.ecom.productCatalog.model.Product;
import com.ecom.productCatalog.repository.ProductRepository;

@Service
public class ProductService {
private final ProductRepository productRepository;

public ProductService(ProductRepository productRepository) {
	
	this.productRepository = productRepository;
}

public List<Product> todosProductos(){
	 return productRepository.findAll();
	
}

public List<Product> productByIdCategory(Long categoryId){
	return productRepository.findByCategoryId(categoryId);
	
}
	
	
	
	
}
