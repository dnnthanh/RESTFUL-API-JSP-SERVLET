package com.laptrinhjavaweb.dao.impl;

import java.util.List;

import com.laptrinhjavaweb.dao.ICategoryDAO;
import com.laptrinhjavaweb.mapper.CategoryMapper;
import com.laptrinhjavaweb.model.CategoryModel;

public class CategoryDAO extends AbstractDAO<CategoryModel> implements ICategoryDAO{

	@Override
	public List<CategoryModel> findAll() {
		String query = "SELECT * FROM web_jsp_servlet.categories";
		return findAll(query, new CategoryMapper());
	}

	@Override
	public CategoryModel findById(Long id) {
		String query = "SELECT * FROM web_jsp_servlet.categories WHERE id = ?";
		return findByFileds(query, new CategoryMapper(), id);
	}
}
