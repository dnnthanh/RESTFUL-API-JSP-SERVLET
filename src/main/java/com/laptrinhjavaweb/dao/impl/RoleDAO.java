package com.laptrinhjavaweb.dao.impl;

import com.laptrinhjavaweb.dao.IRoleDAO;
import com.laptrinhjavaweb.mapper.RoleMapper;
import com.laptrinhjavaweb.model.RoleModel;

public class RoleDAO extends AbstractDAO<RoleModel> implements IRoleDAO {

    @Override
    public RoleModel findById(Long id) {
        String query = "SELECT * FROM role WHERE id = ?";
        return findByFileds(query, new RoleMapper(), id);
    }

}
