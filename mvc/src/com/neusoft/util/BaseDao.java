package com.neusoft.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author WangFuyu
 *
 */

public class BaseDao {
	
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url="jdbc:mysql://localhost:3306/neusoft";
	private static String username = "root";
	private static String password = "123456";
	

	
	
	public Connection getConnection()
	{
		Connection conn = null;
		if(conn==null)
		{
			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url,username,password);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return  conn;
	}
	
	public void closeAll(Connection conn, Statement state,ResultSet rs)
	{
		if(null!=conn)
		{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(null!=state)
		{
			try {
				state.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(null!=rs)
		{
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public int executeUpdate(String preparedSql,Object[] param)
	{
		Connection conn = null;
		PreparedStatement ps = null;
		
		int num = 0;
		
		try {
			conn = getConnection();
			
			ps = conn.prepareStatement(preparedSql);//????
			
			if(null!=param)
			{
				for (int i = 0; i < param.length; i++) {
					ps.setObject(i+1, param[i]);
				}
			}
			
			num = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			closeAll(conn, ps, null);
		}
		return num;
	}
	
	
}
