package com.product.controller;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.product.entity.Product;
import com.product.exception.ResourceNotFoundException;
import com.product.services.ProductServiceImpl;


@RestController
@RequestMapping(path = "api/v1")
public class ProductController {
	
	private ProductServiceImpl productService;
	ProductController(ProductServiceImpl productService){
		this.productService = productService;
	}
	
	@GetMapping(value = "product")
	public Optional<Product> get1( @RequestParam Integer id) {
	   return 	productService.getProductById(id);
		
	}
	@GetMapping(value = "product/{id}")
	public Optional<Product> get( @PathVariable Integer id) {
	   return 	productService.getProductById(id);
		
	}
	@PostMapping(value = "product" )
	public ResponseEntity<Integer> createProduct(
			@RequestBody Product product){
		    Integer id = productService.addProduct(product);
		    return ResponseEntity.ok(id);
		
	}
	@PutMapping(value = "product/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable Integer id,@RequestBody Product product){
		return new ResponseEntity<Product>(productService.updateProduct(product,id),HttpStatus.OK);
	}
	@DeleteMapping(value = "product/{id}")
	public ResponseEntity<Product> deleteProduct(@PathVariable Integer id){
		    productService.deleteProduct(id);
			return  new ResponseEntity<Product>(HttpStatus.OK);
	}
	@DeleteMapping(value = "product")
	public ResponseEntity<Product> deleteAllProduct(){
	    productService.deleteAllProduct();
		return  new ResponseEntity<Product>(HttpStatus.OK);
	}	
	
	
	@GetMapping(value = "products")
	public List<Product> getAllProducts(){
		return productService.getAllProducts();
	}

}
