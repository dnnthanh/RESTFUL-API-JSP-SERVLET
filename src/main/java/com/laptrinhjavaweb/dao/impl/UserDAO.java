package com.laptrinhjavaweb.dao.impl;

import com.laptrinhjavaweb.dao.IUserDAO;
import com.laptrinhjavaweb.mapper.UserMapper;
import com.laptrinhjavaweb.model.UserModel;

public class UserDAO extends AbstractDAO<UserModel> implements IUserDAO {

	@Override
	public UserModel findByUsernameAndPasswordAndStatus(String username, String password, int status) {
		String query = "SELECT * FROM user WHERE username = ? AND password = ? and status = ?";
		return findByFileds(query, new UserMapper(), username, password, status);
	}
}
