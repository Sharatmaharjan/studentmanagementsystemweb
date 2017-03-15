package com.app.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.model.User;
import com.app.servicelayer.UserService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(name="loginservlet",urlPatterns={"/","/login"})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher=request.getRequestDispatcher("views/index.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//StudentService ss=new StudentService();
		
//		String uname=request.getParameter("username");
//		String psw=request.getParameter("password");
//		if(uname.equalsIgnoreCase(arg0))
		UserService us=new UserService();
		User user=new User();
		User user1=new User();
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		try {
			user1=us.login(user);
			if(user1.getUsername()==null){
				request.setAttribute("message", "Invalid username or password.");
				
				RequestDispatcher dispatcher=request.getRequestDispatcher("views/index.jsp");
				dispatcher.forward(request, response);
				
			}
			else{
				//request.setAttribute("message1", "Welcome");
				request.setAttribute("user1", user1);
				RequestDispatcher dispatcher=request.getRequestDispatcher("views/welcome.jsp");
				dispatcher.forward(request, response);
				
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
//		RequestDispatcher dispatcher=request.getRequestDispatcher("views/welcome.jsp");
//		dispatcher.forward(request, response);
	}

}
