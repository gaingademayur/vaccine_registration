

import java.io.IOException;
import java.io.PrintWriter;
import java.security.spec.RSAKeyGenParameterSpec;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.HTML;

import org.apache.jasper.tagplugins.jstl.core.Out;

//import oracle.jdbc.driver.*;
import oracle.jdbc.internal.JMSDequeueOptions;

/**
 * Servlet implementation class Master
 */

public class Master extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();  	
		 out.println("<html><body><form action = \"master.html\"> <input value = \"logout\" type = 'submit' name = 'logout'> </body></html>");
			
		try {
			//DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("Driver loaded successfully.."); 
			Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","activa5g");
			Statement st=c.createStatement();
			
			Cookie ck[]= request.getCookies();
			ck[0].getValue();
			
			ResultSet rs=st.executeQuery("select * from register");
			out.println(" <table border = 1 width = 50% height = 50%");
			out.println("<tr><th>First Name</th><th>Last Name</th><th>Adhar Number</th><th>Age</th><th>City</th><th>Hospital</th></tr>");
			while(rs.next()) {
				out.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td> "+rs.getString(3)+"</td><td> "+rs.getString(4)+"</td><td> "+rs.getString(5)+"</td><td>"+rs.getString(6)+"</td></tr>");
			}
			
		}
		catch(Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
		out.println(" admin is logined");
		
		  out.close();  
		 
	
	}
}


