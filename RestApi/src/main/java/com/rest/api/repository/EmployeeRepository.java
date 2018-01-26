package com.rest.api.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import com.rest.api.pojo.Employee;

public class EmployeeRepository {

	private static List<Employee> empList = null;

	public static List<Employee> getEmployeeDetails() {

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=restdb", "root",
					"");
			System.out.println("connected");
			Statement statement = conn.createStatement();

			String sql = "select * from employee";
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {

				Employee emp = new Employee();
				int id = rs.getInt("empid");
				String name = rs.getString("empname");

				emp.setEmpId(id);
				emp.setEmpName(name);

				empList.add(emp);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return empList;
	}

	public static Employee getEmployee(int id) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=restdb", "root",
					"");
			System.out.println("connected");
			String sql = "select * from employee where empId = ?";
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setInt(1, id);

			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {

				Employee emp = new Employee();
				int empId = rs.getInt("empid");
				String empName = rs.getString("empname");

				emp.setEmpId(empId);
				emp.setEmpName(empName);

				return emp;
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void createEmployee(Employee emp) {

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=restdb", "root",
					"");
			System.out.println("connected");
			Statement statement = conn.createStatement();
			int id = emp.getEmpId();
			String name = emp.getEmpName();
			statement.executeUpdate("insert into employee values(" + id + "," + name + ")");
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
