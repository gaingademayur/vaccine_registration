
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminLoginServlet extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		String i = req.getParameter("uname");
		String j = req.getParameter("pword");
		PrintWriter out = res.getWriter();
		//int count = 1;

		Cookie ck = new Cookie("uname",i);
		res.addCookie(ck);
	if(i.equals("admin") && j.equals("1234")) {
			res.sendRedirect("adminpage");
		}
		else {
		res.sendRedirect("adminlogin.html");
		}
		
	out.println(" "+ i +" "+ j);
	
	}}
