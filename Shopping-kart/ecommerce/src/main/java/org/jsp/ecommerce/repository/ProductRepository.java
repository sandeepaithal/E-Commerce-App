package org.jsp.ecommerce.repository;

import java.util.List;

import org.jsp.ecommerce.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Products, Integer> {
	
	List<Products> findByBrand(String brand);

	List<Products> findByCategory(String category);

	@Query("select p from Products p where p.merchant.id=?1")
	List<Products> findByMerchantId(int merchant_id);

  

}
