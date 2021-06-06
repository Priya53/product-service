package com.edusol.productservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edusol.productservice.model.product;
import com.edusol.productservice.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ProductService productService ;
	
	@GetMapping("/get-products")
	public Object getProducts(){
	
	@SuppressWarnings("unchecked")
	List<product> product=(List <product>)productService.getProducts();
	logger.info(product.toString());
	return product;
	
	}
	@PostMapping("/add-product")
	public Object addProduct(@RequestBody product product) {
		return productService.addProduct(product);
	}
	
	@GetMapping("/get-product-byid")
	public Object getProductById(@RequestParam int id) {
		return productService.getProductById(id);
	}
	
	@GetMapping("/get-product-bycategary")
	public Object getProductByCategary(@RequestParam String categary) {
		return productService.getProductByCategary(categary);
	}
	
	@GetMapping("/get-product-bypricecategary")
	public Object getProductByPriceAndCategary(@RequestParam float price ,String categary) {
		return productService.getProductByPriceAndCategary(price,categary);
	}
	
	@PutMapping("/update-product")
	public Object updateProduct(@RequestBody product product ) {
		return productService.updateProduct(product);
	}
	@DeleteMapping("/delete-product")
	public Object deleteProduct(@RequestParam int id) {
		return productService.deleteProduct(id);
	}
}
