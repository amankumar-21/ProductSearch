package com.example.demo;

import com.example.repository.ProductRepository;
import com.example.entity.Products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan({"com.example.controller","com.example.service"})
@EntityScan("com.example.entity")
@EnableJpaRepositories("com.example.repository")
@SpringBootApplication
public class Try5Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Try5Application.class, args);
	}

	@Autowired
	ProductRepository productRepository;
	
	@Override
	public void run(String... args) throws Exception {
		this.productRepository.save(new Products(1L, "iPhone X", 899,"Apple",4.69f));
		this.productRepository.save(new Products(2L, "iPhone 12", 999,"Apple",4.82f));
		this.productRepository.save(new Products(3L, "Samsung Universe 9", 1249,"Samsung",4.09f));
		this.productRepository.save(new Products(4L, "OPPOF19", 280,"Oppo",4.30f));
		this.productRepository.save(new Products(5L, "Huawei P30", 499,"Huawei",4.20f));
		this.productRepository.save(new Products(6L, "MacBook Pro", 999,"Apple",4.82f));
		this.productRepository.save(new Products(7L, "Samsung Galaxy Book", 1499,"Samsung",4.7f));
		this.productRepository.save(new Products(8L, "Microsoft Surface Laptop 4", 1499,"Microsoft Surface",4.43f));
		this.productRepository.save(new Products(9L, "HP Pavilion 15-DK1056WRoyal_MirageM", 1099,"HP",4.54f));
		this.productRepository.save(new Products(10L, "perfume Oil", 13,"Apple",4.0f));
		
		
	}
}
