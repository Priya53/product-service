package com.edusol.productservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.edusol.productservice.model.product;

public interface ProductRepository extends JpaRepository<product, Integer> {

	List<product> findByCategary(String categary);
	List<product> findByPriceAndCategary(float price,String categary);
}
