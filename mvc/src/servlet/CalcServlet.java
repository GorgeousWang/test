package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/calcServlet")
public class CalcServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8969931993118971942L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Integer num1 =Integer.parseInt(req.getParameter("num1")) ;
		Integer num2 = Integer.parseInt(req.getParameter("num2"));
		PrintWriter out = resp.getWriter();
		out.print(num1+num2);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
	
}
