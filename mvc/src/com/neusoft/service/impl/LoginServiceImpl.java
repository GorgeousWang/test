package com.neusoft.service.impl;

import com.neusoft.dao.LoginDao;
import com.neusoft.dao.impl.LoginDaoImpl;
import com.neusoft.model.User;
import com.neusoft.service.LoginService;

public class LoginServiceImpl implements LoginService {
	private LoginDao loginDao = new LoginDaoImpl();
	boolean flag=false;
	public boolean isExistUser(User user) {
		
		User userNew = loginDao.getUserByusernameAndPassword(user);
		if(userNew!=null)
		{
			flag = true;
		}
	
		return flag;
	}

}
