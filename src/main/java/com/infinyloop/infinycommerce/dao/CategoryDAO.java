package com.infinyloop.infinycommerce.dao;

import java.util.List;

import com.infinyloop.infinycommerce.entity.Category;

public interface CategoryDAO {

	public boolean add(Category category);

	public boolean delete(int id);

	public boolean update(Category category);

	public List<Category> listActive();

	public Category get(int id);

}
