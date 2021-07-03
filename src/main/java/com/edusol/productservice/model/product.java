package com.edusol.productservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PRODUCT")
public class product {
	@Id
	@Column(name="ID")
	private int id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="PRICE")
	private float price;
	
	@Column(name="CATEGARY")
	private String categary;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getCategary() {
		return categary;
	}
	public void setCategary(String categary) {
		this.categary = categary;
	}
	/*@Override
	public String toString() {
		return "product [id=" + id + ", name=" + name + ", price=" + price + ", categary=" + categary + "]";
	}

	public product(int id, String name, float price, String categary) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.categary = categary;
	}*/
	
	
	
	

	
}
