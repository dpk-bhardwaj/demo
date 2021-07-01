package com.deepak.service;

import com.deepak.entity.Product;
import com.deepak.entity.ProductCategory;
import com.deepak.repository.ProductCategoryRepository;
import com.deepak.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ProductCategoryService")
public class ProductCategoryServiceImpl implements ProductCategoryService, ProductSpecificationService {
	
	@Autowired
	ProductCategoryRepository productCategoryRepository;

	@Autowired
	ProductRepository productRepository;

	@Override
	public List<ProductCategory> findAll() {
		return productCategoryRepository.findAll();
	}

	@Override
	public List<Product> getProducts(String groupFilter) {
		return productRepository.findByBrandId(Integer.valueOf(groupFilter));
	}

}
