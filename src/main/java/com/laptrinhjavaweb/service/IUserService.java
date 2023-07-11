package com.laptrinhjavaweb.service;

import java.util.Map;

public interface IUserService {
	
	Map<String, Object> findByUsernameAndPasswordAndStatus(String username, String password, int status);
}
