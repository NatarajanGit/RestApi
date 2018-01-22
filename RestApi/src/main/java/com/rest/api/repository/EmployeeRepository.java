package com.rest.api.repository;

import java.util.ArrayList;
import java.util.List;

import com.rest.api.pojo.Employee;

public class EmployeeRepository {

	List<Employee> empList = null;

	public List<Employee> getEmployeeDetails() {

		initializeArrayList();
		return empList;

	}

	public Employee getEmployee(int id) {

		initializeArrayList();
		for (Employee emp : empList) {
			if (emp.getEmpId() == id) {
				return emp;
			}
		}
		return null;
	}

	public void initializeArrayList() {

		empList = new ArrayList<Employee>();

		Employee emp = new Employee();
		emp.setEmpId(101);
		emp.setEmpName("Vijay");

		Employee newEmp = new Employee();
		newEmp.setEmpId(102);
		newEmp.setEmpName("Jagan");

		empList.add(emp);
		empList.add(newEmp);

	}

}
