package org.jsp.ecommerce.dao;


import java.util.List;
import java.util.Optional;

import org.jsp.ecommerce.model.Products;
import org.jsp.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDao {
	@Autowired
  private ProductRepository productRepository;
  
  public Products saveProduct(Products product) {
		return productRepository.save(product);
	}

	public Optional<Products> findById(int id) {
		return productRepository.findById(id);
	}

	public List<Products> findAll() {
		return productRepository.findAll();
	}

	public List<Products> findByBrand(String brand) {
		return productRepository.findByBrand(brand);
	}

	public List<Products> findByMerchantId(int id) {
		return productRepository.findByMerchantId(id);
	}

	public List<Products> findByCategory(String category) {
		return productRepository.findByCategory(category);
		
	}
	
}
