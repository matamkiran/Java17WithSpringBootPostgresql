package com.application.ecommerce.repo;

import java.util.List;

import com.application.ecommerce.model.Product;


public interface ProductRepo {

	List<Product> findByTitleContainingIgnoreCase(String title);

	
}
