package com.emp.CRUD.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emp.CRUD.DAO.EmployeeDAO;
import com.emp.CRUD.DTO.Employee;


@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		PrintWriter out =res.getWriter();
		String name= req.getParameter("name");
		String email= req.getParameter("email");
		String pass= req.getParameter("pass");
		String cntry= req.getParameter("cntry");
		
		Employee e1 =new Employee();
		e1.setName(name);
		e1.setEmail(email);
		e1.setPass(pass);
		e1.setCntry(cntry);
		
		int status = EmployeeDAO.SaveEmployee(e1);
		if(status > 0) {
			out.print("Record saved Successfully");
		}else {
			out.print("Try again");
		}
		
		out.close();
	}

}
