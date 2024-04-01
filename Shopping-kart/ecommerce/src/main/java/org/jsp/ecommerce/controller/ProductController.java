package org.jsp.ecommerce.controller;

import java.util.List;

import org.jsp.ecommerce.dto.ResponseStructure;
import org.jsp.ecommerce.model.Products;
import org.jsp.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
@CrossOrigin
public class ProductController {
	@Autowired
	private ProductService productService;

	@PostMapping("/{merchant_id}")
	public ResponseEntity<ResponseStructure<Products>> saveProduct(@RequestBody Products product,
			@PathVariable int merchant_id) {
		return productService.saveProduct(product, merchant_id);
	}

	@GetMapping("/{merchant_id}")
	public ResponseEntity<ResponseStructure<List<Products>>> findByMerchantId(@PathVariable int merchant_id) {
		return productService.findProductsByMerchantId(merchant_id);
	}
	@PutMapping
	public ResponseEntity<ResponseStructure<Products>> updateProduct(@RequestBody Products product) {
		return productService.updateProduct(product);
	}
	@GetMapping("/find-by-brand/{brand}")
	public ResponseEntity<ResponseStructure<List<Products>>> findByBrand(@PathVariable String brand) {
		return productService.findByBrand(brand);
	}

	@GetMapping("/find-by-category/{category}")
	public ResponseEntity<ResponseStructure<List<Products>>> findByCategory(@PathVariable String category) {
		return productService.findByCategory(category);
	}

	@GetMapping("/find-by-id/{id}")
	public ResponseEntity<ResponseStructure<Products>> findById(@PathVariable int id) {
		return productService.findById(id);
	}
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteById(@PathVariable int id){
		return productService.deleteById(id);
	}
	@PutMapping("/{user_id}/{product_id}")
	public ResponseEntity<ResponseStructure<List<Products>>> addToCart(@PathVariable int user_id,@PathVariable int product_id){
		return productService.addToCart(user_id, product_id);
	}
	@PutMapping("/wishlist/{user_id}/{product_id}")
	public ResponseEntity<ResponseStructure<List<Products>>> addToWishList(@PathVariable int user_id,@PathVariable int product_id){
		return productService.addToWishList(user_id, product_id);
	}
   @GetMapping("/{user_id}/{product_id})")
   	public ResponseEntity<ResponseStructure<String>> findByProductId(@PathVariable int user_id,@PathVariable int product_id){
	   return productService.findByProductId(user_id,product_id);
   }
	

	
}
