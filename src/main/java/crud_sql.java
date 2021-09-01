

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class crud_sql
 */
@WebServlet("/crud_sql")
public class crud_sql extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public crud_sql() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String i = "joy";
		int j = 15;
		// TODO Auto-generated method stub
		try {
			PrintWriter out= response.getWriter();
			Class.forName("oracle.jdbc.driver.OracleDriver");
			out.println("driver successfully loaded");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","activa5g");
			out.println("driver registered successfully");
			PreparedStatement ps = con.prepareStatement("insert into crud values (?,?)");
			ps.setString(1, i);
			ps.setInt(2, j);
			int z = ps.executeUpdate();
			out.println("data inserted");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void forName(String string) {
		// TODO Auto-generated method stub
		
	}

}
