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


@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out =res.getWriter();
		int status= 0;
		String dt= req.getParameter("dlt");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_crud","root", "Love1999@MySQL");
			PreparedStatement stm = con.prepareStatement("DELETE FROM emp_table WHERE id ="+dt);
			status = stm.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		if(status > 0) {
			out.print("Record Deleted Successfully");
		}else {
			out.print("Try again");
		}
	}

}
