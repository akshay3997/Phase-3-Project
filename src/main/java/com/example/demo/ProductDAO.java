package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductDAO {
	@Autowired
	ProductRepo repo;
	
	public List<Product> ShowProduct(){
		return repo.findAll();
	}

		
}

