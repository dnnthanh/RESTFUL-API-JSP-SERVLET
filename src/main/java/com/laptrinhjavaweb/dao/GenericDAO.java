package com.laptrinhjavaweb.dao;

import java.util.List;

import com.laptrinhjavaweb.mapper.RowMapper;

public interface GenericDAO<T> {
	
	List<T> findAll(String query, RowMapper<T> rowMapper , Object... parameters);
	
	void update(String query, Object... parameters);
	
	Long insert(String query, Object... parameters);
	
	int totalCount(String query);
	
	T findByFileds (String query, RowMapper<T> rowMapper, Object... parameters);
}