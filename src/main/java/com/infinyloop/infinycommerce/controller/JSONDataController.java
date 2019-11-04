package com.infinyloop.infinycommerce.controller;

import java.util.List;

import com.infinyloop.infinycommerce.dao.ProductDAO;
import com.infinyloop.infinycommerce.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/json/data")
public class JSONDataController {

	@Autowired
    ProductDAO productDAO;
	
	@RequestMapping("/all/products")
	@ResponseBody
	public List<Product> listActiveProducts(){
		return productDAO.listActiveProducts();
	}
	
	@RequestMapping("/category/{id}/products")
	@ResponseBody
	public List<Product> listProductsByCategory(@PathVariable("id") int id){
		return productDAO.listActiveProductsByCategory(id);
	}
	
	@RequestMapping("/admin/all/products")
	@ResponseBody
	public List<Product> listAll(){
		return productDAO.listAll();
	}
	
	
	
}
