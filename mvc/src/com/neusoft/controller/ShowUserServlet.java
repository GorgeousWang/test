package com.neusoft.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.model.User;
import com.neusoft.service.ShowUserService;
import com.neusoft.service.impl.ShowUserServiceImpl;
@WebServlet("/showUsersServlet")
public class ShowUserServlet extends HttpServlet {
	
	
	
	private ShowUserService showUserService = new ShowUserServiceImpl();
	private static final long serialVersionUID = -8368085116881511363L;

			protected void doGet(HttpServletRequest req, HttpServletResponse resp)
					throws ServletException, IOException {
				this.doPost(req, resp);
			}
			
			protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
				req.setCharacterEncoding("utf-8");
				resp.setCharacterEncoding("utf-8");
				String method = req.getParameter("method");
				if(method!=null&&method.equals("delete"))
				{
					 Integer id =Integer.parseInt(req.getParameter("id"));
					 
					boolean flag =  showUserService.deleteUserById(id);
					if(flag)
					{
						serarchAll(req, resp);
					}
				}
				else if(method!=null&&method.equals("add")){
					
					Integer id = Integer.parseInt(req.getParameter("id"));
					if(id==null)
					{
						User user = new User(req.getParameter("username"),req.getParameter("password"));
						showUserService.addUser(user);
						serarchAll(req, resp);
					}
					else
					{
						User user = new User(Integer.parseInt(req.getParameter("id")),req.getParameter("username"),req.getParameter("password"));
						showUserService.updateUser(user);
						serarchAll(req,resp);
					}
					
				}
				else if(method!=null&&method.equals("update")){
				
					Integer id =Integer.parseInt(req.getParameter("id"));
					User user = showUserService.getUserById(id);
					req.setAttribute("user", user);
					req.getRequestDispatcher("add.jsp").forward(req,resp);
					
					
				}
				else{
					serarchAll(req, resp);
				}
				
				
				
				
				
			}

			private void serarchAll(HttpServletRequest req,
					HttpServletResponse resp) throws ServletException,
					IOException {
				List<User> users = showUserService.getAllUser();
				req.setAttribute("users", users);
				req.getRequestDispatcher("showusers.jsp").forward(req,resp);
			}
			
			
			
			
			
			
			
			
			
			
}
