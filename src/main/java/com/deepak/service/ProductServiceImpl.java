package com.deepak.service;

import com.deepak.common.services.SpecificationFactory;
import com.deepak.entity.Product;
import com.deepak.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("ProductService")
public class ProductServiceImpl implements ProductService {

	@Autowired
	ApplicationContext applicationContext;

	@Autowired
	ProductGroupByBrand brandService;

	@Autowired
	ProductRepository productRepository;

	@Override
	public Map<String, List<Product>> getProducts(String groupFilter, String groupByValue) throws Exception {
		GroupByService groupByService = SpecificationFactory.getInstance(applicationContext, groupFilter);
		if (groupByService != null) {
			return groupByService.getProducts(groupByValue);
		}
		return brandService.getProducts(groupByValue);
	}

	@Override
	public Map<String, List<Product>> getProducts() {
		return brandService.getProducts(null);
	}
}

