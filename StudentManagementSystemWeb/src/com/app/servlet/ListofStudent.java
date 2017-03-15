package com.app.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.model.Student;
import com.app.servicelayer.StudentService;

/**
 * Servlet implementation class ListofStudent
 */
@WebServlet(name="list ofstudent",urlPatterns="/listofstudent")
public class ListofStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListofStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		List<Student> lis=new ArrayList<Student>();
		StudentService ss=new StudentService();
		lis=ss.getAllStudent();
		request.setAttribute("list", lis);
		RequestDispatcher dispatcher=request.getRequestDispatcher("views/listofstudent.jsp");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		List<Student> lis=new ArrayList<>();
//		StudentService ss=new StudentService();
//		lis=ss.getAllStudent();
//		RequestDispatcher dispatcher=request.getRequestDispatcher("views/listofstudent.jsp");
//		dispatcher.forward(request, response);
//		request.setAttribute("list", lis);
		//("list",$(lis));
	}

}
