package com.neusoft.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neusoft.model.User;
import com.neusoft.service.LoginService;
import com.neusoft.service.impl.LoginServiceImpl;
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	
	private LoginService loginService = new LoginServiceImpl();
	private static final long serialVersionUID = -7743379480807126912L;

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
		protected void doPost(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException 
		{
			HttpSession session = req.getSession();
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			//username password发送给service层
			boolean flag = loginService.isExistUser(new User(username, password));
			if(flag==true){
				session.setAttribute("user", new User(username,password));
				resp.sendRedirect("index.jsp");
			}
			else{
				
//				resp.sendRedirect("Login.jsp");
				
				req.setAttribute("tip", "用户名和密码不正确");
				req.getRequestDispatcher("Login.jsp").forward(req, resp);
				
			}
		}
}
