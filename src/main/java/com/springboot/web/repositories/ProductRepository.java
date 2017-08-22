package com.springboot.web.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.web.domain.Product;
 
@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
}
