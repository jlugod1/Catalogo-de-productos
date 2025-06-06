package com.ecom.productCatalog.controler;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.productCatalog.model.Product;
import com.ecom.productCatalog.services.ProductService;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "http://localhost:5173")

public class ProductController {
private final ProductService productService;

public ProductController(ProductService productService) {
	this.productService = productService;
}
@GetMapping
public List<Product> getProductAll(){
	return productService.todosProductos();
}
	
@GetMapping("/category/{categoryId}")
public List<Product> getProductAllById(@PathVariable Long categoryId){
	return productService.productByIdCategory(categoryId);
}
	
	
}
