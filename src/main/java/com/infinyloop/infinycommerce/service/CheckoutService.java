package com.infinyloop.infinycommerce.service;

import java.util.Date;
import java.util.List;

import com.infinyloop.infinycommerce.entity.Account;
import com.infinyloop.infinycommerce.entity.Cart;
import com.infinyloop.infinycommerce.entity.CartLine;
import com.infinyloop.infinycommerce.entity.OrderItem;
import com.infinyloop.infinycommerce.model.CheckoutModel;
import com.infinyloop.infinycommerce.dao.AccountDAO;
import com.infinyloop.infinycommerce.dao.OrderItemDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.infinyloop.infinycommerce.dao.AddressDAO;
import com.infinyloop.infinycommerce.dao.CartDAO;
import com.infinyloop.infinycommerce.dao.CartLineDAO;
import com.infinyloop.infinycommerce.dao.OrderDetailDAO;
import com.infinyloop.infinycommerce.entity.OrderDetail;

@Service
public class CheckoutService {
	
	@Autowired
    AccountDAO accountDAO;

	@Autowired
    AddressDAO addressDAO;

	@Autowired
    CartLineDAO cartLineDAO;

	@Autowired
    OrderDetailDAO orderDetailDAO;

	@Autowired
    OrderItemDAO orderItemDAO;

	@Autowired
	CartDAO cartDAO;

	@Autowired
	ProductService productService;

	public void placeOrder(CheckoutModel model, List<CartLine> itemsList) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Account account = accountDAO.get(authentication.getName());
		
		OrderDetail order = new OrderDetail();
		order.setAccountId(account.getId());
		order.setBillingId(addressDAO.getBillingAddress(account).getId());
		order.setShippingId(model.getShipping().getId());
		order.setOrderDate(new Date());
		order.setOrderCount(model.getCartLines().size());
		order.setTotal(model.getCheckoutTotal());

		model.setOrderDetail(order);

		orderDetailDAO.add(order);

		for (CartLine line : itemsList) {
			OrderItem item = new OrderItem();
			item.setOrderId(order.getId());
			item.setPrice(line.getProductPrice());
			item.setProduct(line.getProduct());
			item.setProductCount(line.getProductCount());
			item.setTotalPrice(line.getTotal());
			orderItemDAO.add(item);
			cartLineDAO.delete(line.getId());

			productService.addPurchase(item.getProduct(), item.getProductCount());
		}

		Cart currentCart = model.getCart();
		currentCart.setCartLines(0);
		currentCart.setTotal(0);
		cartDAO.updateCart(currentCart);

		account.setCart(currentCart);
	}
}
