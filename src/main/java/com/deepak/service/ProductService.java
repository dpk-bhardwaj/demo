package com.deepak.service;

import com.deepak.common.enums.GroupSpecification;
import com.deepak.entity.Product;

import java.util.List;
import java.util.Map;

public interface ProductService {

    Map<String, List<Product>> getProducts(GroupSpecification filter, String value);
}
