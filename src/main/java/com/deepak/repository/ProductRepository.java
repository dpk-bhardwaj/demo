package com.deepak.repository;

import com.deepak.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	@Query("SELECT p FROM Product p WHERE p.colorId.id = :colorId")
	List<Product> findByColorId(@Param(value = "colorId") Integer colorId);

	@Query("SELECT p FROM Product p WHERE p.brandId.id = :brandId")
	List<Product> findByBrandId(@Param(value = "brandId") Integer brandId);
	
	List<Product> findBySize(String actualvalue);
}
