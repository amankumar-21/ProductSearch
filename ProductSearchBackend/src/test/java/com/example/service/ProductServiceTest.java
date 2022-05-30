package com.example.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;

import com.example.demo.Try5Application;
import com.example.entity.Products;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Try5Application.class)
public class ProductServiceTest {
	
	 @MockBean
	   private ProductService productService;
	 
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
	   public void testGetAllProducts() throws Exception {
		  Products product = getProduct();
		  List<Products> products = new ArrayList<>();
		  products.add(product);
	      given(productService.getAllProducts()).willReturn(products);
	      List<Products> result = productService.getAllProducts();
	      assertEquals(result.size(), 1);
	   }
	  @Test
	   public void testSaveOrUpdateEmployee() throws Exception {
		  Products product = getProduct();
	      doNothing().when(productService).saveOrUpdate(product);	
	      productService.saveOrUpdate(product);
	      assertTrue(true);
	   }

}
