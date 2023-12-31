package com.laptrinhjavaweb.service.impl;

import javax.inject.Inject;

import com.laptrinhjavaweb.dao.IRoleDAO;
import com.laptrinhjavaweb.model.RoleModel;
import com.laptrinhjavaweb.service.IRoleService;

public class RoleService implements IRoleService {

    @Inject
    private IRoleDAO roleDAO;

    @Override
    public RoleModel findById(Long id) {
        return this.roleDAO.findById(id);
    }

}
