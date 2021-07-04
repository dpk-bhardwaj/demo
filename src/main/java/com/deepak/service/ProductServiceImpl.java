package com.deepak.service;

import com.deepak.common.enums.GroupSpecification;
import com.deepak.common.services.SpecificationFactory;
import com.deepak.entity.Product;
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

	@Override
	public Map<String, List<Product>> getProducts(GroupSpecification groupFilter, String groupByValue) {
		if (groupFilter != null) {
			GroupByService groupByService = SpecificationFactory.getInstance(applicationContext, groupFilter.getValue());
			if (groupByService != null) {
				return groupByService.getProducts(groupByValue);
			}
		}
		return brandService.getProducts(groupByValue);
	}
}

