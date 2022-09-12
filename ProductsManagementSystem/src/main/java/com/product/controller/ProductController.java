package com.product.controller;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	public Optional<Product> get( @RequestParam Integer id) {
	   return 	productService.getProductById(id);
		
	}
	@PostMapping(value = "product" )
	public ResponseEntity<Integer> createProduct(
			@RequestBody Product product){
		    Integer id = productService.addProduct(product);
		    return ResponseEntity.ok(id);
		
	}
	
	@GetMapping(value = "products")
	public List<Product> getAllProducts(){
		return productService.getAllProducts();
	}

}
