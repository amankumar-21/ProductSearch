package com.example.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Products;
import com.example.service.ProductService;


@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService ;

	@RequestMapping("/products")
	public List<Products> getAllProducts()
	{
		return productService.getAllProducts();
		
	}
	
	 @PostMapping("/product")
	   public void addProduct(@RequestBody Products product) 
	 {
		 productService.saveOrUpdate(product);
	   }
	

}
