package com.infinyloop.infinycommerce.dao;

import java.util.List;

import com.infinyloop.infinycommerce.entity.CartLine;
import com.infinyloop.infinycommerce.entity.Product;

public interface CartLineDAO {

	public CartLine get(int id);

	public boolean add(CartLine cartLine);

	public boolean update(CartLine cartLine);

	public boolean delete(int id);

	public List<CartLine> listAll(int cartId);

	public List<CartLine> listAvailable(int cartId);

	public CartLine get(int cartId, Product product);
}
