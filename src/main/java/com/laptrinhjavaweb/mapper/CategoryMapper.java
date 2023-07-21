package com.laptrinhjavaweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.laptrinhjavaweb.model.CategoryModel;

public class CategoryMapper implements RowMapper<CategoryModel> {

    @Override
    public CategoryModel mapRow(ResultSet resultSet) {
        CategoryModel categoryModel = new CategoryModel();
        try {
            categoryModel.setId(resultSet.getLong("id"));
            categoryModel.setCode(resultSet.getString("code"));
            categoryModel.setName(resultSet.getString("name"));
            categoryModel.setCreatedDate(resultSet.getTimestamp("createdate"));
            categoryModel.setCreatedBy(resultSet.getString("createdby"));
            categoryModel.setModifiedDate(resultSet.getTimestamp("modifieddate"));
            categoryModel.setModifiedBy(resultSet.getString("modifiedby"));
            return categoryModel;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

}
