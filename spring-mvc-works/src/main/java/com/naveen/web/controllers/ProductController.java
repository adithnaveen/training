package com.naveen.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.naveen.beans.Product;
import com.naveen.exception.DaoException;
import com.naveen.interfaces.IProductDao;
import com.naveen.validators.ProductValidator;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
public class ProductController {

	@Autowired(required = true)
	IProductDao productDao;

	@RequestMapping(method = RequestMethod.GET, path = "/all-products")
	public String getAllProduct(Model model) throws DaoException {

		model.addAttribute("pageTitle", "List All Products"); 
		model.addAttribute("PRODUCTS", productDao.getAllProducts());
		return "show-products";
	}


	@RequestMapping(method=RequestMethod.GET, path="/products-by-price-range")
	public String getProductsByPriceRange(Model model, @RequestParam Double min, @RequestParam Double max) {
		
		model.addAttribute("pageTitle", "Product price between " +  min +", and " + max); 
		model.addAttribute("PRODUCTS", productDao.getProductsByPriceRange(min, max)); 
		
		return "show-products"; 
	}
	
	@RequestMapping("/product-details")
	public String getProductDetails(@RequestParam Integer productId, Model model) {
		model.addAttribute("PRODUCT", productDao.getProduct(productId)); 
		return "product-details"; 
	}
	
	@RequestMapping(path = "/add-product", method = RequestMethod.GET)
	public String addProduct(Model model) {
		model.addAttribute("product", new Product()); 
		
		// 2nd version it can be kept in another method as to do auto binding 
//		model.addAttribute("CATEGORIES",  productDao.getCategoryList()); 
		return "product-form"; 
	}
	
	
	
	
	
	
	
	
	
	

	@RequestMapping(path = "/edit-product", method = RequestMethod.GET)
	public String editProduct(Model model,  @RequestParam Integer productId) {
		model.addAttribute("product", productDao.getProduct(productId)); 
		return "product-form"; 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@ModelAttribute("CATEGORIES")
	public List<String> getCategoryList(){
		return productDao.getCategoryList(); 
	}
	

	// this will generate 302 server code 
	@RequestMapping(path = "/save-product", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute Product product, BindingResult errors) {
		
		ProductValidator productValidator = new ProductValidator();
		productValidator.validate(product, errors);
		if(errors.hasErrors()) {
			return "product-form"; 
		}

		// by default even edit will also add the product 
		productDao.addProduct(product); 
		return "redirect:product-details?productId="+product.getProductId();
	}
	

	
	// error handler 
	
	
	// second version it is refracted and kept in GlobalExceptionHander
//	@ExceptionHandler(value = Exception.class)
//	public String errorHandler(Exception ex, Model model ) {
//		log.error(ex.getLocalizedMessage());
//		model.addAttribute("ex", ex); 
//		return "err"; 
//	}
	
	
	
	
	
	
	
}
