package com.infinyloop.infinycommerce.model;

import java.io.Serializable;

import com.infinyloop.infinycommerce.entity.Cart;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id;

	private String firstName;

	private String lastName;

	private String userRole;
	
	private Cart cart;

	public String getFullName() {
		return this.firstName+" "+this.lastName;
	}
	

}
