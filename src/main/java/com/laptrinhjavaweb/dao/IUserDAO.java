package com.laptrinhjavaweb.dao;

import com.laptrinhjavaweb.model.UserModel;

public interface IUserDAO {

    UserModel findByUsernameAndPasswordAndStatus(String username, String password, int status);
}
