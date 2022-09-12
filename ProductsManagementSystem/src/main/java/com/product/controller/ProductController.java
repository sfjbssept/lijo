package com.product.controller;

import javax.websocket.server.PathParam;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.product.entity.Product;
import com.product.services.ProductServiceImpl;


@RestController
@RequestMapping(path = "api/v1")
public class ProductController {
	
	private ProductServiceImpl productService;
	ProductController(ProductServiceImpl productService){
		this.productService = productService;
	}
	
	@GetMapping(value = "product")
	public Product get(@PathParam(value = "12") @RequestParam Integer id) {
	   return 	productService.getProductById(id);
		
	}
	@RequestMapping(value = "product" , method = RequestMethod.POST)
	public ResponseEntity<Integer> createProduct(
			@RequestBody Product product){
		    Integer id = productService.addProduct(product);
		    return ResponseEntity.ok(id);
		
	}

}
