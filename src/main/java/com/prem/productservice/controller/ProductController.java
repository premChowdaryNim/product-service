package com.prem.productservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.prem.productservice.dto.ProductRequest;
import com.prem.productservice.dto.ProductResponse;
import com.prem.productservice.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

	private final ProductService productService;
	 
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void createproduct(@RequestBody ProductRequest productRequest) {
		 productService.createProduct(productRequest);
	}
	
	 @GetMapping
	 @ResponseStatus(HttpStatus.OK)
	 public List<ProductResponse> getAllProducts() {
	      return productService.getAllProducts();
	 }
}
