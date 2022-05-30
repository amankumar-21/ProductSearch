package com.example.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.demo.Try5Application;
import com.example.entity.Products;

@ExtendWith(SpringExtension.class)
@Transactional
@SpringBootTest(classes = Try5Application.class)
public class ProductRepositoryTest {
	@Autowired
	ProductRepository productRepository;
	
	 private Products getProduct() {
		 Products product = new Products();
		 product.setId(1L);
		 product.setName("Samsung S20 ultra");
		 product.setprice(650);
		 product.setBrand("Samsung");
		 product.setRating(4.3f);
	      return product;
	   }
	  @Test
	   public void testFindAll() {
		  Products product = getProduct();
	      productRepository.save(product);
	      List<Products> result = new ArrayList<>();
	      productRepository.findAll().forEach(e -> result.add(e));
	      assertTrue(result.size() > 1);	     
	   }
	   @Test
	   public void testSave() {
		   Products product = getProduct();
	      productRepository.save(product);
	      Products found = productRepository.findById(product.getId()).get();
	      assertEquals(product.getId(), found.getId());	     
	   }

}
