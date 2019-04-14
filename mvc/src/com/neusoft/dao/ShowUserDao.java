package com.neusoft.dao;

import java.util.List;

import com.neusoft.model.User;

public interface ShowUserDao {
		public List<User> getAllUser();
		public int deleteUserById(int id);
		public int addUser(User user);
		public User getUserById(Integer id);
		public int updateUser(User user);
		public boolean getUserByUsername(String username);
}
