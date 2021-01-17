import java.io.*;
import java.sql.*;
import javax.servlet.*;  
import javax.servlet.http.*;   

public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		// TODO Auto-generated method stub
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter(); 
		
		String firstName=request.getParameter("f");
        String lastName=request.getParameter("l");
        String u_name=request.getParameter("u");
        String password=request.getParameter("p");
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/uk2","root",""); 
			 PreparedStatement pstmt = null;
			 pstmt = con.prepareStatement("INSERT INTO dd1 values (?, ?, ?,?)");
			  pstmt.setString(1, firstName);
	            pstmt.setString(2, lastName);
	            pstmt.setString(3, u_name);
	            pstmt.setString(4, password);
	             pstmt.executeUpdate();
	            out.print(firstName+" "+ lastName);
	              out.println("<h2 style='color:green;padding-left:80px'><i>You are successfully registered...</i></h2>");
	              request.getRequestDispatcher("login.html").include(request, response);
                  con.close();pstmt.close();}catch (Exception e2) {out.println(e2);}
                        out.close();}}