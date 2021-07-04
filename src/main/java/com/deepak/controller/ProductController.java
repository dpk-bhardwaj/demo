package com.deepak.controller;

import com.deepak.entity.Product;
import com.deepak.exception.B2CException;
import com.deepak.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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
	public ResponseEntity<Map<String, List<Product>>> getProducts(@RequestParam(required = false) String filter,
                                                     			  @RequestParam(required = false) String value) throws Exception {
		Map<String, List<Product>> products = productService.getProducts(filter, value);
		if(CollectionUtils.isEmpty(products))
			throw new B2CException("Product not found!");
		
		return new ResponseEntity<Map<String, List<Product>>>(products,
				new HttpHeaders(), HttpStatus.OK);
	}

}