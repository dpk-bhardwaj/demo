package com.deepak.service;

import com.deepak.entity.Product;

import java.util.List;

public interface SpecificationService {

    List<Product> getProducts(String groupBySpecification, String groupFilter) throws Exception;
}
