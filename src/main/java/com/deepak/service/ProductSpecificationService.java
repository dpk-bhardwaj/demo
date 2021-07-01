package com.deepak.service;


import com.deepak.entity.Product;

import java.util.List;

/**
 * Created by emp304 on 4/3/2018.
 */
public interface ProductSpecificationService {

    List<Product> getProducts(String filterValue) throws Exception;

}
