package com.deepak.service;

import com.deepak.entity.Brand;
import com.deepak.entity.Product;
import com.deepak.repository.BrandRepository;
import com.deepak.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("BrandService")
public class BrandServiceImpl implements BrandService, ProductSpecificationService {
	
	@Autowired
	BrandRepository brandRepository;

	@Autowired
	ProductRepository productRepository;

	@Override
	public List<Brand> findAll() {
		return brandRepository.findAll();
	}

	@Override
	public List<Product> getProducts(String groupFilter) {
		return productRepository.findByBrandId(Integer.valueOf(groupFilter));
	}

}
