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
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
@Slf4j
public class ProductController {

	private final ProductService productService;
	 
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void createproduct(@RequestBody ProductRequest productRequest) {
		log.info("Entered Product Service");
		 productService.createProduct(productRequest);
		log.info("Exited Product Service");

	}
	
	 @GetMapping
	 @ResponseStatus(HttpStatus.OK)
	 public List<ProductResponse> getAllProducts() {
		log.info("Entered Product Service");
	      return productService.getAllProducts();
	 }
}
