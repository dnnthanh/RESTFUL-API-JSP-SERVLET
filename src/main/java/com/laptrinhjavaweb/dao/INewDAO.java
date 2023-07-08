package com.laptrinhjavaweb.dao;

import java.util.List;

import com.laptrinhjavaweb.model.NewModel;

import pagingandsorting.PagingAndSorting;

public interface INewDAO{
	
	List<NewModel> findAllByCategoryId(Long categoryId);
	
	Long save(NewModel newModel);
	
	NewModel findById(Long id);
	
	void update(NewModel updateNew);
	
	void delete(Long id);
	
	int totalCount();
	
	List<NewModel> findAll(PagingAndSorting ps);
}
