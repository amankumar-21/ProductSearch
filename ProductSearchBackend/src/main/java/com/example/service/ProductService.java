package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Products;
import com.example.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository ;
	
	 public List<Products> getAllProducts(){
		 List<Products> products = new ArrayList<Products>();
		 productRepository.findAll().forEach(product -> products.add(product));
	      return products;
	   }
	 public void saveOrUpdate(Products product) {
		 productRepository.save(product);
	   }
	 
}
