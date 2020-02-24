package com.naveen.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.naveen.beans.Product;

public class ProductValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(Product.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// 2nd parameter -> request parameter 
		// 3rd parameter -> to check if its empty it will look for the key productName.empty in error-message.properties
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "productName", "productName.empty",
				"ProductName is Mandatory");

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "productId", "productId.empty", "ProductId is Mandatory");

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "productPrice", "productPrice.empty",
				"ProductPrice is Mandatory");

		Product product = (Product) target;
		Integer productId = product.getProductId();
		Double productPrice = product.getProductPrice();

		if (productId != null && productId < 0) {
			errors.rejectValue("productId", "productId.invalid", "Product Id must be > 0");
		}

		if (productPrice != null && productPrice < 0) {
			errors.rejectValue("productPrice", "productPrice.invalid", "Product price must be > 0");
		}
		

		
		
		
		
		
	}
}
