package com.example.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.CrossOrigin;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;

import com.example.demo.Try5Application;
import com.example.entity.Products;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin(origins = "http://localhost:3000/")
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Try5Application.class)
@AutoConfigureMockMvc
public class ProductControllerTest {

	@Autowired
	   private MockMvc mvc;
	@MockBean
	   private ProductController productController;
	
	
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
	      given(productController.getAllProducts()).willReturn(products);
	      
	      mvc.perform(get("/products/").contentType(APPLICATION_JSON)).andExpect(status().isOk())
	         .andExpect(jsonPath("$[0].name", is(product.getName())));
	   }
	
	 @Test
	   public void testAddProduct() throws Exception {
		 Products product = getProduct();
	      doNothing().when(productController).addProduct(product);
	      mvc.perform(post("/product/").content(asJson(product)).contentType(APPLICATION_JSON))
	         .andExpect(status().isOk()).andReturn();
	   }
	
	 private static String asJson(final Object obj) {
	      try {
	         return new ObjectMapper().writeValueAsString(obj);
	      } catch (Exception e) {
	         throw new RuntimeException(e);
	      }
	   }
	
	
}
