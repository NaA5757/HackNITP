

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class s4 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter(); 
		try {
			
		  Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/uk1","root","");
			 request.getRequestDispatcher("All.html").include(request, response);
			 PreparedStatement pstmt = null;
			 pstmt = con.prepareStatement("select * from art");
			 ResultSet rs= pstmt.executeQuery();
			 out.print("<h1 style='color:blue;padding-left:100px;padding-top:50px;'><b>"+"Blog"+"</b></h1>");
			 while(rs.next()) {
				 out.print("<div style='width:100%;height:auto;padding:1%;'><div><img src='E:\\pic5.jpg' height='50px' width='30px' style=' margin-left:2%;\r\n"
				 		+ "float:left; \r\n"
				 		+ "height:40px;\r\n"
				 		+ "width:40px; '><h3 style='color:green;'><i>"+" "+rs.getString(2)+" "+rs.getString(3)+"</i></h3></div></div>");
				 out.print("<p style='padding-left:80px;border:1px;border-style:solid;padding:lem;border-color:red;border-style:dotted; '>"+rs.getString(1)+"</p>");
				 out.print("<br><br>");
			 }
			 
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
