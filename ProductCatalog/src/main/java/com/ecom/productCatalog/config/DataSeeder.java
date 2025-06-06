package com.ecom.productCatalog.config;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ecom.productCatalog.model.Category;
import com.ecom.productCatalog.model.Product;
import com.ecom.productCatalog.repository.CategoryRepository;
import com.ecom.productCatalog.repository.ProductRepository;

@Component
public class DataSeeder implements CommandLineRunner {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
	
	
	public DataSeeder(ProductRepository productRepository, CategoryRepository categoryRepository) {
		
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
	}


	@Override
	public void run(String... args) throws Exception{
		
		//limpiar toda la data
		categoryRepository.deleteAll();
		productRepository.deleteAll();
		
		
		//Añadiendo categorias de los productos
		Category electronics = new Category();
		electronics.setName("Electronics");
		
		Category clothing = new Category();
		clothing.setName("clothing");
		
		Category home = new Category();
		home.setName("home");
		
		categoryRepository.saveAll(Arrays.asList(electronics, home, clothing));
		
		//Crear productos
		Product phone = new Product();
		phone.setName("smartphone");
		phone.setDescription("El mejor telefono del mundo");
		phone.setPrice(699.99);
		phone.setImagUrl("https://placehold.co/600x400");
		phone.setCategory(electronics);
		
		Product laptop = new Product();
		laptop.setName("laptop");
		laptop.setDescription("La mejor laptop del mundo");
		laptop.setPrice(1199.99);
		laptop.setCategory(electronics);
		laptop.setImagUrl("https://placehold.co/600x400");
		
		
		Product jacket = new Product();
		jacket.setName("Winter jacket");
		jacket.setDescription("excelente para el invierno");
		jacket.setPrice(9.99);
		jacket.setCategory(clothing);
		jacket.setImagUrl("https://placehold.co/600x400");
		
		Product blender = new Product();
		blender.setName("Blenber");
		blender.setDescription("excelente para el invierno");
		blender.setPrice(19.99);
		blender.setCategory(home);
		blender.setImagUrl("https://placehold.co/600x400");
		productRepository.saveAll(Arrays.asList(phone, laptop, blender, jacket));
	}

}
