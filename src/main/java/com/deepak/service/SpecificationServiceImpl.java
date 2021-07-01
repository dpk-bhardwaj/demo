package com.deepak.service;

import com.deepak.common.services.SpecificationFactory;
import com.deepak.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecificationServiceImpl implements SpecificationService {

    private SpecificationFactory specificationFactory;

    @Override
    public List<Product> getProducts(String groupByValue, String actualValue) throws Exception {
        ProductSpecificationService productSpecificationService = specificationFactory.getSpecification(groupByValue);
        return productSpecificationService.getProducts(actualValue);
    }

    @Autowired
    public void setSpecificationFactory(SpecificationFactory specificationFactory) {
        this.specificationFactory = specificationFactory;
    }
}
