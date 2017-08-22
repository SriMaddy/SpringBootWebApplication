package com.springboot.web.service;

import com.springboot.web.domain.Product;

public interface ProductService {

	Iterable<Product> listAllProducts();

	Product getProductById(Integer id);
	
	void deleteProduct(Integer id);

	Product saveProduct(Product product);
}
