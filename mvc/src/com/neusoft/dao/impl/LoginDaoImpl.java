package com.neusoft.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.neusoft.dao.LoginDao;
import com.neusoft.model.User;
import com.neusoft.util.BaseDao;

public class LoginDaoImpl implements LoginDao {

	User userNew =null;
	private BaseDao baseDao = new BaseDao();
	private Connection conn;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	public User getUserByusernameAndPassword(User user) 
	
	{
		try {
			conn = baseDao.getConnection();
			String sql ="select * from user where username=? and password=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			rs = ps.executeQuery();
			while(rs.next())
			{
				userNew= new User(rs.getString("username"),rs.getString("password"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userNew;
	}

}
