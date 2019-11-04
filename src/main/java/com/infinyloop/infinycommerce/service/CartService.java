package com.infinyloop.infinycommerce.service;

import java.util.List;

import com.infinyloop.infinycommerce.dao.AccountDAO;
import com.infinyloop.infinycommerce.dao.CartDAO;
import com.infinyloop.infinycommerce.dao.CartLineDAO;
import com.infinyloop.infinycommerce.entity.Account;
import com.infinyloop.infinycommerce.entity.Cart;
import com.infinyloop.infinycommerce.entity.CartLine;
import com.infinyloop.infinycommerce.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class CartService {

	@Autowired
	private CartLineDAO cartLineDAO;

	@Autowired
	private AccountDAO accountDAO;
	
	@Autowired
	private CartDAO cartDAO;


	public Cart getCart() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Account account = accountDAO.get(auth.getName());
		Cart cart = account.getCart();
		return cart;
	}

	public void addCartLine(Product product) {

		Cart cart = this.getCart();
		cart.setCartLines(cart.getCartLines() + 1);

		CartLine cartLine = new CartLine();
		cartLine.setProduct(product);
		cartLine.setAvailable(product.isActive());
		cartLine.setCartId(cart.getId());
		cartLine.setProductCount(1);
		cartLine.setProductPrice(product.getUnitPrice());
		cartLine.setTotal(cartLine.getProductCount() * product.getUnitPrice());
		cartLineDAO.add(cartLine);

		cart.setTotal(this.countTotal());
		cartDAO.updateCart(cart);

	}

	public void deleteCartLine(CartLine cartLine) {
		Cart cart = this.getCart();

		cart.setCartLines(cart.getCartLines() - 1);
		cartLineDAO.delete(cartLine.getId());

		cart.setTotal(this.countTotal());
		cartDAO.updateCart(cart);

	}

	public void updateCartLine(int cartLineId, int quantity) {

		CartLine cartLine = cartLineDAO.get(cartLineId);
		Cart cart = this.getCart();

		cartLine.setProductCount(quantity);
		cartLine.setTotal(cartLine.getProductPrice() * quantity);
		cartLineDAO.update(cartLine);

		cart.setTotal(this.countTotal());
		cartDAO.updateCart(cart);

	}

	public boolean checkProductInCartLine(Product product) {

		Cart userCart = this.getCart();
		try {
			if (cartLineDAO.get(userCart.getId(), product) != null) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public Double countTotal() {

		List<CartLine> cartlines = this.getCartLines();
		double total = 0;
		for (CartLine line : cartlines) {
			double lineTotal = line.getProductCount() * line.getProductPrice();
			total += lineTotal;
		}
		return total;
	}

	public List<CartLine> getCartLines() {
		Cart cart = this.getCart();

		return cartLineDAO.listAll(cart.getId());
	}

}
