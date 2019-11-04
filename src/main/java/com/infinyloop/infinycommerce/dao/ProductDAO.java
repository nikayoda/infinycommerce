package com.infinyloop.infinycommerce.dao;

import java.util.List;

import com.infinyloop.infinycommerce.entity.Product;


public interface ProductDAO {

	public boolean add(Product product);

	public boolean delete(int id);

	public boolean update(Product product);

	public boolean findById(int id);

	public Product get(int id);
	
	public List<Product> getAllActiveSortedByViews();
	
	public List<Product> listActiveProducts();
	
	public List<Product> listActiveProductsByCategory(int categoryId);
	
	public List<Product> getLatestActiveProducts(int count);
	
	public List<Product> listAll();

	
	
}
