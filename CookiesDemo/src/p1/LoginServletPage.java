package p1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginServletPage extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		Cookie arr[] = request.getCookies(); // during first hit we dont cookie , we will get null
		String username = "";
		String password = "";
		boolean cookieFound = false;
		
		if(arr != null)
		{
			cookieFound = true;
			for(Cookie c:arr)
			{
				String cookieName = c.getName();
				if(cookieName.equals("username")) username = c.getValue();
				if(cookieName.equals("password")) password = c.getValue();
			}
		}
		
		
		out.print("<HTML><BODY>");
		out.print("<form method='post' action='LoginServletPage'>");
			
			out.print(" Username <input type='text' name='username' value='"+username+"'><br/>");
			out.print("Password <input type='text' name='password' value='"+password+"'><br/>");
			out.print("<input type='checkbox' name='remember' value='remember'/>");
			
			out.print(" Remember me");
			out.print("<input type='submit'>");
			
		out.print("</form>");
		out.print("</BODY></HTML>");
		
		
		
	
	
	}//end of doGet
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String remember = request.getParameter("remember");
		
		
		if(remember != null)
		{
			// add cookies
			Cookie cookie1 = new Cookie("username",username);
			Cookie cookie2 = new Cookie("password",password);
			
			cookie1.setMaxAge(1000*60*60*24);
			cookie2.setMaxAge(1000*60*60*24);
			
			response.addCookie(cookie1);
			response.addCookie(cookie2);
			System.out.println(" ---- >> Cookies Added...");
			
		}
		response.getWriter().append("Welcome "+username);
	}
	

}//end Servlet
