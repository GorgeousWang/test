package com.neusoft.service;

import java.util.List;

import com.neusoft.model.User;

public interface ShowUserService {
		public List<User> getAllUser();
		public boolean deleteUserById(int id);
		public int addUser(User user);
		public User getUserById(Integer id);
		public int updateUser(User user);
		public boolean isExistsUsername(String username);
}
