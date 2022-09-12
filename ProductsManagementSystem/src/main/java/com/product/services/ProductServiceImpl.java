package com.product.services;

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

	public Product getProductById(Integer id) {
		Product product =null;
		try {
			product =  productRepository.getReferenceById(id);
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		 return product;
	}

}
