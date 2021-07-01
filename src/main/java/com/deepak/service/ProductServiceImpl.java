package com.deepak.service;

import com.deepak.entity.Product;
import com.deepak.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ProductService")
public class ProductServiceImpl implements ProductService, ProductSpecificationService {

	@Autowired
	ProductRepository productRepository;

	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	@Override
	public List<Product> getProducts(String groupFilter) {
		return productRepository.findByBrandId(Integer.valueOf(groupFilter));
	}
}

