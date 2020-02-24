package com.naveen.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {

	private Integer productId;
	private String productName;
	private Double productPrice;
	
	//use this when you dont want to send the response in json in REST 
//	@JsonIgnore
	private String  categoryName;

}
