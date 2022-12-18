package com.emp.CRUD.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.emp.CRUD.DTO.Employee;

public class EmployeeDAO 
{
	public static int SaveEmployee(Employee emp) 
	{
		int status =0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_crud","root", "Love1999@MySQL");
			PreparedStatement stm = con.prepareStatement("insert into emp_table(name,password,email,country)values(?,?,?,?)");
			stm.setString(1, emp.getName());
			stm.setString(2, emp.getPass());
			stm.setString(3, emp.getEmail());
			stm.setString(4, emp.getCntry());
			status = stm.executeUpdate();
			con.close();
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return status;		
	}
	public static List<Employee> getEmployee() {
		ArrayList<Employee> li=new ArrayList<Employee>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_crud","root", "Love1999@MySQL");
			PreparedStatement stm =con.prepareStatement("select * from emp_table");
			ResultSet rs=stm.executeQuery();
			while(rs.next()) {
				Employee em = new Employee();
				em.setId(rs.getInt(1));
				em.setName(rs.getString(2));
				em.setEmail(rs.getString(3));
				em.setPass(rs.getString(4));
				em.setCntry(rs.getString(5));
				li.add(em);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		return li;
	}
}
