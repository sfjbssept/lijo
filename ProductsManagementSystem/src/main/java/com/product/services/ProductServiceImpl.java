package com.product.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.entity.Product;
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

}
