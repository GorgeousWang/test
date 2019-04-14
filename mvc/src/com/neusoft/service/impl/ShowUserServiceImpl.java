package com.neusoft.service.impl;

import java.util.List;

import com.neusoft.dao.ShowUserDao;
import com.neusoft.dao.impl.ShowUserDaoImpl;
import com.neusoft.model.User;
import com.neusoft.service.ShowUserService;

public class ShowUserServiceImpl implements ShowUserService {

	
	private ShowUserDao showUserDao = new ShowUserDaoImpl();
	@Override
	public List<User> getAllUser() {
		return showUserDao.getAllUser();
	}
	@Override
	public boolean deleteUserById(int id) {
		boolean flag = false;
		int i = showUserDao.deleteUserById(id);
		if(i!=0)
		{
			flag = true;
		}
		return flag;
	}
	@Override
	public int addUser(User user) {
		
		int  flag = 0;
		int i = showUserDao.addUser(user);
		if(i!=0)
		{
			flag = i;
		}
		return flag;
	}
	@Override
	public User getUserById(Integer id) {
		return showUserDao.getUserById(id);
	}
	@Override
	public int updateUser(User user) {
		
		return showUserDao.updateUser(user);
		
	}
	@Override
	public boolean isExistsUsername(String username) {
		return showUserDao.getUserByUsername(username);
	}
	

}
