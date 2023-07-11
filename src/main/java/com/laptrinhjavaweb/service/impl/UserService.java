package com.laptrinhjavaweb.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import com.laptrinhjavaweb.dao.IRoleDAO;
import com.laptrinhjavaweb.dao.IUserDAO;
import com.laptrinhjavaweb.model.RoleModel;
import com.laptrinhjavaweb.model.UserModel;
import com.laptrinhjavaweb.service.IUserService;

public class UserService implements IUserService {

	@Inject
	private IUserDAO userDAO;
	
	@Inject
	private IRoleDAO roleDAO;

	@Override
	public Map<String, Object> findByUsernameAndPasswordAndStatus(String username, String password, int status) {
		Map<String, Object> mapData = new HashMap<>();
		UserModel model = this.userDAO.findByUsernameAndPasswordAndStatus(username, password, status);
		if(model == null) {
			return null;
		}
		RoleModel roleModel = this.roleDAO.findById(model.getRoleId());
		mapData.put("model", model);
		mapData.put("role", roleModel);
		return mapData;
	}

}
