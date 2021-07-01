package com.deepak.controller;

import com.deepak.entity.ProductCategory;
import com.deepak.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/productcategories")
public class ProductCategoryController {
	@Autowired
	ProductCategoryService productCategoryService;

	@GetMapping
	public ResponseEntity<List<ProductCategory>> findAll() {
		List<ProductCategory> list = productCategoryService.findAll();

		return new ResponseEntity<List<ProductCategory>>(list, new HttpHeaders(), HttpStatus.OK);
	}
}