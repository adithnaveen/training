package com.naveen.web.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.naveen.beans.Product;
import com.naveen.interfaces.IProductDao;

@RequestMapping("/api/products")
@RestController
public class ProductResource {

	@Autowired
	IProductDao productDao;

	// if you dont have jackson dependencies it will given an error
	// as there is no converter
	@RequestMapping(method = RequestMethod.GET)
	public List<Product> getAllProducts() {
		return productDao.getAllProducts();
	}

	@RequestMapping(method = RequestMethod.GET, path = "/{productId}")
	public Product getProduct(@PathVariable Integer productId) {
		return productDao.getProduct(productId);
	}
	
	
	// do the same for all other methos like POST / PUT/DELETE
}
