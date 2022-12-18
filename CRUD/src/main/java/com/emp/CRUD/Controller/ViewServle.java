package com.emp.CRUD.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emp.CRUD.DAO.EmployeeDAO;
import com.emp.CRUD.DTO.Employee;

@WebServlet("/ViewServle")
public class ViewServle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("<a href='index.html'>Add employee</a>");
		out.println("<h1>Employee informations</h1>");
		List<Employee> l =EmployeeDAO.getEmployee();
		out.println("<table border='1' width='100%'>");
		out.println("<tr><th>ID of Employee</th><th>Name</th><th>Password</th><th>Email</th><th>Country</th><th>Edit</th><th>Delete</th></tr>");
		for(Employee c:l) {
			out.println("<tr><td>"+c.getId()+"</td><td>"+c.getName()+"</td><td>"+c.getEmail()+"</td><td>"+c.getPass()+"</td><th>"+c.getCntry()+"</td><td><a href='index.html'>Edit</a></td><td><a href='Edit'>Delete</a></td></tr> ");
		}
		out.println("</table>");
		
		
	}

}
