package com.deepak.service;


import com.deepak.entity.Product;

import java.util.List;
import java.util.Map;

public interface GroupByService {

    Map<String, List<Product>> getProducts(String groupFilter);

}
