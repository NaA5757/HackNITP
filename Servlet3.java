

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.*; 

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.*; 

public class Servlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException  {
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter(); 
		String u_name=request.getParameter("u_name");
		String password=request.getParameter("password");
		try {
			
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/uk2","root",""); 
			 PreparedStatement pstmt = null;
			 pstmt = con.prepareStatement(" select * from dd1 where u_name = ? and password = ? ");
			pstmt.setString(1, u_name);
			pstmt.setString(2, password); 
			HttpSession session=request.getSession();  
	       
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) { session.setAttribute("f_name",rs.getString(1));
			 session.setAttribute("l_name",rs.getString(2)); 
				}
			request.getRequestDispatcher("All.html").include(request, response);
		}catch(Exception e) {System.out.println(e);}
	}

}
