package com.infinyloop.infinycommerce.model;

import java.io.Serializable;
import java.util.List;

import com.infinyloop.infinycommerce.entity.Account;
import com.infinyloop.infinycommerce.entity.Address;
import com.infinyloop.infinycommerce.entity.Cart;
import lombok.Getter;
import lombok.Setter;
import com.infinyloop.infinycommerce.entity.CartLine;
import com.infinyloop.infinycommerce.entity.OrderDetail;

@Getter
@Setter
public class CheckoutModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Account account;
	private Address shipping;
	private Cart cart;
	private List<CartLine> cartLines;
	private OrderDetail orderDetail;
	private double checkoutTotal;
	
}