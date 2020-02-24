package com.naveen.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.naveen.beans.Product;
import com.naveen.interfaces.IProductDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ProductDAO implements IProductDao {

	static List<Product> productList;
	static {
		productList = new ArrayList<Product>();

		productList.add(new Product(Integer.valueOf(101), "Computer", Double.valueOf(2345), "Electronics"));
		productList.add(new Product(Integer.valueOf(102), "Mobile", Double.valueOf(123), "Electronics"));
		productList.add(new Product(Integer.valueOf(103), "Pen", Double.valueOf(10), "Stationary"));
		productList.add(new Product(Integer.valueOf(104), "Tablet", Double.valueOf(321), "Electronics"));
		productList.add(new Product(Integer.valueOf(105), "Screen Guard", Double.valueOf(3), "Electronics"));

	}

	@Override
	public List<Product> getAllProducts() {

		return productList;

	}

	// 10 500
	@Override
	public Object getProductsByPriceRange(Double min, Double max) {

		List<Product> pricedList = new ArrayList<Product>();

		for (Product product : productList) {
			if (product.getProductPrice() < max && product.getProductPrice() > min) {
				pricedList.add(product);
			}
		}

		
		System.out.println(pricedList);
		return pricedList;
	}

	@Override
	public void addProduct(Product product) {

		productList.add(product); 
		
	}

	@Override
	public Product getProduct(Integer productId) {

		 return 
			productList.stream().filter(t -> t.getProductId() == productId).findAny().get();  
	}

	@Override
	public List<String> getCategoryList() {
		return Arrays.asList("Electronics", "Stationary", "Home Needs", "Vegetables", "Others");
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
