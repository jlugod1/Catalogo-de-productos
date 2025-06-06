package com.ecom.productCatalog.model;


import jakarta.persistence.*;


import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity

public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    private  String name;
    
@OneToMany(mappedBy = "category",  cascade = CascadeType.ALL,
    fetch = FetchType.LAZY)
@JsonManagedReference
    private Set<Product> products;




public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public Set<Product> getProducts() {
	return products;
}

public void setProducts(Set<Product> products) {
	this.products = products;
}

public Category() {
	
}




}
