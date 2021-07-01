package com.deepak.service;

import com.deepak.entity.Color;
import com.deepak.entity.Product;
import com.deepak.repository.ColorRepository;
import com.deepak.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ColorService")
public class ColorServiceImpl implements ColorService, ProductSpecificationService {
	
	@Autowired
	ColorRepository colorRepository;

	@Autowired
	ProductRepository productRepository;

	@Override
	public List<Color> findAll() {
		return colorRepository.findAll();
	}

	@Override
	public List<Product> getProducts(String groupFilter) {
		return productRepository.findByColorId(Integer.valueOf(groupFilter));
	}
	
}
