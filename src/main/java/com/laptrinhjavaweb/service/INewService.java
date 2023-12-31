package com.laptrinhjavaweb.service;

import java.util.Map;

import com.laptrinhjavaweb.model.NewModel;
import com.laptrinhjavaweb.pagingandsorting.PagingAndSorting;

public interface INewService {

    //List<NewModel> findAllByCategoryId (Long categoryId);

    NewModel save(NewModel newModel);

    NewModel update(NewModel updateNew);

    void delete(Long[] ids);

    Map<String, Object> findAll(PagingAndSorting ps);

    Map<String, Object> findById(Long id);
}
