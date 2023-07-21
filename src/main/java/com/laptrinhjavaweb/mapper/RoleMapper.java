package com.laptrinhjavaweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.laptrinhjavaweb.model.RoleModel;

public class RoleMapper implements RowMapper<RoleModel> {

    @Override
    public RoleModel mapRow(ResultSet resultSet) {
        RoleModel roleModel = new RoleModel();
        try {
            roleModel.setId(resultSet.getLong("id"));
            roleModel.setCode(resultSet.getString("code"));
            roleModel.setName(resultSet.getString("name"));
            roleModel.setCreatedDate(resultSet.getTimestamp("createdate"));
            roleModel.setCreatedBy(resultSet.getString("createdby"));
            roleModel.setModifiedDate(resultSet.getTimestamp("modifieddate"));
            roleModel.setModifiedBy(resultSet.getString("modifiedby"));
            return roleModel;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

}
