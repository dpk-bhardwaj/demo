package com.deepak.service;

import com.deepak.common.enums.GroupSpecification;
import com.deepak.common.services.SpecificationFactory;
import com.deepak.entity.Product;
import com.deepak.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component("ProductCategoryService")
public class ProductGroupByCategory implements GroupByService {

	static {
		SpecificationFactory.register(GroupSpecification.CATEGORY.getValue(), ProductGroupByCategory.class);
	}

	@Autowired
	ProductRepository productRepository;

	@Override
	public Map<String, List<Product>> getProducts(String groupFilter) {
		List<Product> products;
		if (StringUtils.hasLength(groupFilter))
			products = productRepository.findByProductCategoryName(groupFilter + "%");
		else
			products = productRepository.findAll();
		return products.stream().collect(Collectors.groupingBy(w -> w.getCatagoryId().getName()));
	}

}
