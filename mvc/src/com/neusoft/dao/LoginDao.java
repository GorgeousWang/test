package com.neusoft.dao;

import com.neusoft.model.User;

public interface LoginDao {
	public User getUserByusernameAndPassword(User user);
}
