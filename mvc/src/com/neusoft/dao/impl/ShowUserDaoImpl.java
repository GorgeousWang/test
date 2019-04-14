package com.neusoft.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neusoft.dao.ShowUserDao;
import com.neusoft.model.User;
import com.neusoft.util.BaseDao;

public class ShowUserDaoImpl implements ShowUserDao {
		private BaseDao baseDao = new BaseDao();
		private Connection conn ;
		private PreparedStatement ps;
		private ResultSet rs ;
	@Override
	public List<User> getAllUser() 
	{
			List<User> users = new ArrayList<User>();
			conn = baseDao.getConnection();
			String sql = "select * from user";
			try {
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				while(rs.next())
				{
					User user  = new User(rs.getInt("id"),rs.getString("username"),rs.getString("password"));
					users.add(user);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally{
				baseDao.closeAll(conn, ps, rs);
			}
		
		return users;
	}
	
	/**
	 * 删除用户
	 */
	@Override
	public int deleteUserById(int id) {
		
		String preparedSql="delete from user where id=?";
		return baseDao.executeUpdate(preparedSql, new Object[]{id});
	}

	@Override
	public int addUser(User user) {
		String sql = "insert into user(username,password) values(?,?)";
		//返回添加操作影响的数据库行数
		return baseDao.executeUpdate(sql, new Object[]{user.getUsername(),user.getPassword()});
		
	}

	@Override
	public User getUserById(Integer id) {
		
		User user =null;
		try {
			conn = baseDao.getConnection();
			String sql = "select * from user t where t.id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next())
			{
				 user  = new User(rs.getInt("id"),rs.getString("username"),rs.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			baseDao.closeAll(conn, ps, rs);
		}
		
		return user;
	}
   /**
    * 修改用户
    */
	@Override
	public int updateUser(User user) {
		String sql = "update user set username=? , password=? where id=?";
		return baseDao.executeUpdate(sql, new Object[]{user.getUsername(),user.getPassword(),user.getId()});
	}

@Override
public boolean getUserByUsername(String username) {
	boolean flag = false;
	conn = baseDao.getConnection();
	/**
	 * String sql="select count(*) as number from user where username=?";
	 */
	String sql = "select * from user where username=?";
	try {
		ps=conn.prepareStatement(sql);
		ps.setString(1, username);
		rs=ps.executeQuery();
		while(rs.next())
		{
			flag = true;
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return flag;
}

}
