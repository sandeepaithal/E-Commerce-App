package org.jsp.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.jsp.ecommerce.dao.MerchantDao;
import org.jsp.ecommerce.dao.ProductDao;
import org.jsp.ecommerce.dto.ResponseStructure;
import org.jsp.ecommerce.exception.MerchantNotFoundException;
import org.jsp.ecommerce.exception.ProductNotFoundException;
import org.jsp.ecommerce.model.Merchant;
import org.jsp.ecommerce.model.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	@Autowired
	private ProductDao productDao;
	@Autowired
	private MerchantDao merchantDao;

	public ResponseEntity<ResponseStructure<Products>> saveProduct(Products product, int merchant_id) {
		Optional<Merchant> recMechant = merchantDao.findById(merchant_id);
		ResponseStructure<Products> structure = new ResponseStructure<>();
		if (recMechant.isPresent()) {
			Merchant merchant = recMechant.get();
			merchant.getProducts().add(product);
			product.setMerchant(merchant);
			structure.setBody(productDao.saveProduct(product));
			structure.setMessage("Product Added");
			structure.setStatusCode(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<Products>>(structure, HttpStatus.CREATED);
		}
		throw new MerchantNotFoundException("cannot add Product as Merchant Id is Invalid");
	}

	public ResponseEntity<ResponseStructure<List<Products>>> findProductsByMerchantId(int merchant_id) {
		ResponseStructure<List<Products>> structure = new ResponseStructure<>();
		List<Products> products = productDao.findByMerchantId(merchant_id);
		if (products.isEmpty()) {
			throw new ProductNotFoundException("No Products Found for entered Merchant Id");
		}
		structure.setBody(products);
		structure.setMessage("List of Products for Merchant Id");
		structure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<Products>>>(structure, HttpStatus.OK);
	}
	public ResponseEntity<ResponseStructure<Products>> updateProduct(Products product) {
		ResponseStructure<Products> structure = new ResponseStructure<>();
		Optional<Products> recProduct = productDao.findById(product.getId());
		if (recProduct.isEmpty()) {
			throw new ProductNotFoundException("cannot update product as Id is Invalid");
		}
		Products dbProduct = recProduct.get();
		dbProduct.setBrand(product.getBrand());
		dbProduct.setCategory(product.getCategory());
		dbProduct.setDescription(product.getDescription());
		dbProduct.setCost(product.getCost());
		dbProduct.setImage_url(product.getImage_url());
		structure.setBody(productDao.saveProduct(dbProduct));
		structure.setMessage("Product Updated");
		structure.setStatusCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<Products>>(structure, HttpStatus.ACCEPTED);

	}

	public ResponseEntity<ResponseStructure<Products>> findById(int id) {
		ResponseStructure<Products> structure = new ResponseStructure<>();
		Optional<Products> recProduct = productDao.findById(id);
		if (recProduct.isEmpty()) {
			throw new ProductNotFoundException("Invalid Product Id");
		}
		structure.setBody(recProduct.get());
		structure.setMessage("Product Found");
		structure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<Products>>(structure, HttpStatus.OK);
	}
	public ResponseEntity<ResponseStructure<List<Products>>> findByBrand(String brand) {
		ResponseStructure<List<Products>> structure = new ResponseStructure<>();
		List<Products> products = productDao.findByBrand(brand);
		if (products.isEmpty()) {
			throw new ProductNotFoundException("No Products Found for entered brand");
		}
		structure.setBody(products);
		structure.setMessage("List of Products for the entered brand");
		structure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<Products>>>(structure, HttpStatus.OK);
	}

	

	public ResponseEntity<ResponseStructure<List<Products>>> findByCategory(String category) {
		ResponseStructure<List<Products>> structure = new ResponseStructure<>();
		List<Products> products = productDao.findByCategory(category);
		if (products.isEmpty()) {
			throw new ProductNotFoundException("No Products Found for entered Category");
		}
		structure.setBody(products);
		structure.setMessage("List of Products for entered Category");
		structure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<Products>>>(structure, HttpStatus.OK);
	}
	}
	

	


