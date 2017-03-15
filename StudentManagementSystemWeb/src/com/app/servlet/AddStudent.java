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
 * Servlet implementation class AddStudent
 */
@WebServlet(name="add students",urlPatterns={"/addstudent","/added"})
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher=request.getRequestDispatcher("views/add.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Student student=new Student();
		StudentService ss=new StudentService();
		student.setName(request.getParameter("name"));
		student.setAddress(request.getParameter("address"));
		student.setSurname(request.getParameter("surname"));
		student.setPhone(request.getParameter("phone"));
		ss.addStudent(student);
		List<Student> lis=new ArrayList<Student>();
		lis=ss.getAllStudent();
		request.setAttribute("list", lis);
		RequestDispatcher dispatcher=request.getRequestDispatcher("views/listofstudent.jsp");
		dispatcher.forward(request, response);
	}

}
