package com.rest.api.repository;

import java.util.ArrayList;
import java.util.List;

import com.rest.api.pojo.Employee;

public class EmployeeRepository {

	private static List<Employee> empList = null;

	public static List<Employee> getEmployeeDetails() {
		return empList;

	}

	public static Employee getEmployee(int id) {
		for (Employee emp : empList) {
			if (emp.getEmpId() == id) {
				return emp;
			}
		}
		return null;
	}

	public static void createEmployee(Employee emp) {
			empList.add(emp);
	}

	static {

		empList = new ArrayList<Employee>();

		Employee emp1 = new Employee();
		emp1.setEmpId(101);
		emp1.setEmpName("Vijay");

		Employee emp2 = new Employee();
		emp2.setEmpId(102);
		emp2.setEmpName("Jagan");

		empList.add(emp1);
		empList.add(emp2);

	}
}
