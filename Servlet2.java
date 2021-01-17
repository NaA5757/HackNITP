import java.io.*;
import java.sql.*;
import javax.servlet.*;  
import javax.servlet.http.*;  
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.ServletContext;
@MultipartConfig(maxFileSize = 16177215)
  public class Servlet2 extends HttpServlet {  
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException  {
	  response.setContentType("text/html");  
		PrintWriter out = response.getWriter(); 
		 String ar = request.getParameter("art");
	  try {
		  
		  HttpSession session=request.getSession(false);  
	        String f_name=(String)session.getAttribute("f_name");  
	        String l_name=(String)session.getAttribute("l_name");  
		  Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/uk1","root","");
			request.getRequestDispatcher("post.html").include(request, response);
			PreparedStatement pstmt1 = null;
			 pstmt1 = con.prepareStatement("INSERT INTO art values (? ,? ,?)");
			 pstmt1.setString(1, ar);
			 pstmt1.setString(2, f_name);
			 pstmt1.setString(3, l_name);
			 int t=pstmt1.executeUpdate();
	  }catch(Exception e) {
		  System.out.println(e);
	  }
  }
  }