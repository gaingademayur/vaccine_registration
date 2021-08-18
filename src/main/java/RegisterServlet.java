
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException {
		
		
	
		String i = req.getParameter("fname");
		String j = req.getParameter("lname");
		String k = req.getParameter("adharno");
		int l = Integer.parseInt(req.getParameter("age"));
		String m = req.getParameter("city");
		String n = req.getParameter("hospital");
		PrintWriter out = res.getWriter();
		
		try
        {  
             //load the driver
             Class.forName("oracle.jdbc.driver.OracleDriver");  
             //create connection object
             System.out.println("driver loaded succesfully..");
             
             Connection con=DriverManager.getConnection( "jdbc:oracle:thin:@localhost:1521:xe","system","activa5g");  
             // create the prepared statement object
             PreparedStatement ps=con.prepareStatement("insert into register values(?,?,?,?,?,?)");  

             ps.setString(1, i);
             ps.setString(2, j);  
             ps.setString(3, k);
             ps.setInt(4, l);
             ps.setString(5, m);
             ps.setString(6, n);

             int z = ps.executeUpdate();  
             if(z>0)  
             out.print("You are successfully registered...");  
        }
        catch (Exception ex)
        {
             ex.printStackTrace();
        }
		
		
		   out.println("<script type=\"text/javascript\">");
		   out.println("alert('Your lot has been successfully registered');");
		  // out.println("location='master.html';");
		   out.println("</script>");
		
		res.sendRedirect("master.html");
        out.close();  
		//out.println(" "+ i +" "+ j+" "+k+" "+l+" "+m+" "+n);
        
	}
		
}


