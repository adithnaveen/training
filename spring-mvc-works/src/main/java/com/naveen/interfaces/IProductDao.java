package com.naveen.interfaces;

import java.util.List;

import com.naveen.beans.Product;

public interface IProductDao {

	public List<Product> getAllProducts();

	public Object getProductsByPriceRange(Double min, Double max);

	public void addProduct(Product product);

	public Product getProduct(Integer productId);
	
	public List<String> getCategoryList(); 
}
