package com.ecommerce.repositorysamples;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.modelsamples.Products;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Integer>  {

	List<Products> findByCategory(String Category);
	
}
