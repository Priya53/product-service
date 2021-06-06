package com.edusol.productservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.edusol.productservice.model.product;
import com.edusol.productservice.repository.ProductRepository;
import com.google.gson.JsonObject;

@Service
public class ProductService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	ProductRepository productRepository;
	public Object getProducts() {
		
		return productRepository.findAll();
	}
	public Object addProduct(product product) {
		logger.info(product.toString());
	 productRepository.save(product);
	 logger.info("Product added successfully");
		return new ResponseEntity<>("Product added successfully",HttpStatus.CREATED);
	}

	public Object getProductById(int id) {
		return productRepository.findById(id);
	}
	public Object getProductByCategary(String categary) {
		
	return productRepository.findByCategary(categary);
	}

	public Object updateProduct(product product) {
		JsonObject response= new JsonObject();
		System.out.println("Request product : "+ product);
		int id=product.getId();
		try {
			product prod=productRepository.getOne(id);
			prod.setPrice(product.getPrice());
			productRepository.save(prod);
		}catch(Exception e){
		logger.error(e.getMessage());
		
		response.addProperty("statusCode", 404);
		response.addProperty("statusMessage", e.getMessage());
		
		return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
		logger.info("Product updated successfully");
	return new ResponseEntity<>("Product updated successfully",HttpStatus.OK);
	}
	
	public Object deleteProduct(int id) {
		try {
		productRepository.deleteById(id);
		}catch (Exception e) {
			logger.error(e.getMessage());	
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
			}
			logger.info("Product deleted successfully");
		return new ResponseEntity<>("Product deleted successfully",HttpStatus.OK);
		}
	
	public Object getProductByPriceAndCategary(float price, String categary) {
	
		return productRepository.findByPriceAndCategary(price, categary);
	}

}
