package com.deepak.controller;

import com.deepak.common.enums.GroupSpecification;
import com.deepak.common.models.BasicRdo;
import com.deepak.entity.Product;
import com.deepak.exception.ProductNotFoundException;
import com.deepak.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	ProductService productService;

	@GetMapping()
	public ResponseEntity<BasicRdo> getProducts(@RequestParam(required = false) GroupSpecification filter,
												@RequestParam(required = false) String value) throws Exception {
		BasicRdo basicRdo = new BasicRdo();
		Map<String, List<Product>> products = productService.getProducts(filter, value);
		if(CollectionUtils.isEmpty(products))
			throw new ProductNotFoundException("Product not found!");
		
		return basicRdo.getResponse("OK",
				HttpStatus.OK, products);
	}

}