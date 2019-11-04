package com.infinyloop.infinycommerce.dao;

import java.util.List;

import com.infinyloop.infinycommerce.entity.OrderItem;

public interface OrderItemDAO {

	public boolean add(OrderItem orderItem);

	public boolean delete(int id);

	public boolean update(OrderItem orderItem);

	public List<OrderItem> list(int orderDetailId);

	public OrderItem get(int id);
	
}
