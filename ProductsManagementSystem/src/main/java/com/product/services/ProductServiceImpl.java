package com.product.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.entity.Product;
import com.product.exception.ResourceNotFoundException;
import com.product.repo.IProductRepository;


@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	IProductRepository productRepository;
	
	@Override
	public Integer addProduct(Product product) {
		product = productRepository.save(product);
		return product.getId();
	}

	public Optional<Product> getProductById(Integer id) {
		Optional<Product> product =null;
		try {
			product =  productRepository.findById(id);
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		 return product;
	}
	
	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	public Product updateProduct(Product product, Integer id) {
		Product exProduct = productRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("id","Product",id));
		product.setId(exProduct.getId());
		return productRepository.save(product);
	}

	public void deleteProduct(Integer id) {
		productRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("id","Product",id));
		productRepository.deleteById(id);
		
	}

	public void deleteAllProduct() {
		productRepository.deleteAll();
		
	}

}
