package com.deepak.repository;

import com.deepak.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	@Query("SELECT p FROM Product p WHERE p.colorId.name like (:colorName)")
	List<Product> findByColorName(@Param(value = "colorName") String colorName);

	@Query("SELECT p FROM Product p WHERE p.brandId.name like (:brandName)")
	List<Product> findByBrandName(@Param(value = "brandName") String brandName);

	@Query("SELECT p FROM Product p WHERE p.catagoryId.name like (:categoryName)")
	List<Product> findByProductCategoryName(@Param(value = "categoryName") String categoryName);
	
	List<Product> findBySize(String actualvalue);
}
