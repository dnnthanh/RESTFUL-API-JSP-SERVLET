package com.laptrinhjavaweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.laptrinhjavaweb.model.UserModel;

public class UserMapper implements RowMapper<UserModel> {

    @Override
    public UserModel mapRow(ResultSet resultSet) {
        UserModel userModel = new UserModel();
        try {
            userModel.setId(resultSet.getLong("id"));
            userModel.setUsername(resultSet.getString("username"));
            userModel.setPassword(resultSet.getString("password"));
            userModel.setFullName(resultSet.getString("fullname"));
            userModel.setStatus(resultSet.getInt("status"));
            userModel.setRoleId(resultSet.getLong("roleid"));
            userModel.setCreatedDate(resultSet.getTimestamp("createdate"));
            userModel.setCreatedBy(resultSet.getString("createdby"));
            userModel.setModifiedDate(resultSet.getTimestamp("modifieddate"));
            userModel.setModifiedBy(resultSet.getString("modifiedby"));
            return userModel;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

}
