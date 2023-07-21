package com.laptrinhjavaweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.laptrinhjavaweb.model.NewModel;

public class NewMapper implements RowMapper<NewModel> {

    @Override
    public NewModel mapRow(ResultSet resultSet) {
        NewModel newModel = new NewModel();
        try {
            newModel.setId(resultSet.getLong("id"));
            newModel.setTitle(resultSet.getString("title"));
            newModel.setContent(resultSet.getString("content"));
            newModel.setDescriptionshort(resultSet.getString("descriptionshort"));
            newModel.setThumbnail(resultSet.getString("thumbnail"));
            newModel.setCreatedDate(resultSet.getTimestamp("createdate"));
            newModel.setCreatedBy(resultSet.getString("createdby"));
            newModel.setCategoryId(resultSet.getLong("categoryid"));
            newModel.setModifiedDate(resultSet.getTimestamp("modifieddate"));
            newModel.setModifiedBy(resultSet.getString("modifiedby"));
            return newModel;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
