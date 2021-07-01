package com.deepak.repository;

import com.deepak.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCategoryRepository 
        extends JpaRepository<ProductCategory, Integer> {
 
}
