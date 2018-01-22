package com.rest.api.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.rest.api.pojo.Employee;
import com.rest.api.repository.EmployeeRepository;

@Path("employee")
public class EmployeeResource {
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Employee> getAllEmployee() {
		return new EmployeeRepository().getEmployeeDetails();
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Employee getEmployee(@PathParam("id") int id) {
		return new EmployeeRepository().getEmployee(id);
	}

}
