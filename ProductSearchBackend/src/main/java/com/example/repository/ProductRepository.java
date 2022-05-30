package com.example.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Products;

@Repository
public interface ProductRepository extends CrudRepository<Products, Long>
{

}
