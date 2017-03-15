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
 * Servlet implementation class DeleteStudent
 */
@WebServlet(name="delete students",urlPatterns={"/delete","/deleted"})
public class DeleteStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		//System.out.println("Name "+name);
		Student student=new Student();
		StudentService ss=new StudentService();
		student=ss.getStudentByName(name); //how to access name from /edit?name= url?
		//System.out.println("name"+student.getName());
		request.setAttribute("student", student);
		RequestDispatcher dispatcher=request.getRequestDispatcher("views/delete.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	Student student=new Student();
	StudentService ss=new StudentService();
	student.setName(request.getParameter("name"));
	ss.deleteStudent(student);
	List<Student> lis=new ArrayList<Student>();
	lis=ss.getAllStudent();
	request.setAttribute("list", lis);
	RequestDispatcher dispatcher=request.getRequestDispatcher("views/listofstudent.jsp");
	dispatcher.forward(request, response);
	
	}

}
