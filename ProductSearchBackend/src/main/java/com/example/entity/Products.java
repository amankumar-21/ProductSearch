package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Products {
	@Id
	@Column
	@GeneratedValue
	private Long id;
	@Column
    private String name;
	@Column
    private int price;
	@Column
    private String brand;
	@Column
    private float rating;    
    
	

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getprice() {
        return price;
    }

    public void setprice(int price) {
        this.price = price;
    }
        
    public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}
    
    
    public Products() {
    }
   
    public Products(Long id, String name, int price,String brand,float rating) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.brand=brand;
        this.rating=rating;    }
    
    

}

