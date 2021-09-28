package com.ecommerce.servicesamples;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.modelsamples.Products;

import com.ecommerce.repositorysamples.ProductsRepository;

@Service
@Transactional
public class ProductsService {
	@Autowired
	private ProductsRepository productsRepo;
	
	public List<Products> listAll(String category) {
		if(category != null) {
			return productsRepo.findByCategory(category);
		}
		return productsRepo.findAll();
	}
	
	public void save(Products products) {
		productsRepo.save(products);
	}
	
	public Products get(int productId) {
		return productsRepo.findById(productId).get();
	}
	
	public void delete(int productId) {
		productsRepo.deleteById(productId);
	}
    
	
}
