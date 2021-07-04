package com.deepak.service;

import com.deepak.entity.Product;

import java.util.List;
import java.util.Map;

public interface ProductService {

    Map<String, List<Product>> getProducts();

    Map<String, List<Product>> getProducts(String groupFilter, String groupByValue) throws Exception;
}
