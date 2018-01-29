package com.rest.api.resource;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.rest.api.pojo.Employee;
import com.rest.api.repository.EmployeeRepository;

@Path("employee")
public class EmployeeResource {
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Employee> getAllEmployee() {
		return EmployeeRepository.getEmployeeDetails();
	}
	
	@GET
	@Path("{id}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Employee getEmployee(@PathParam("id") int id) {
		return EmployeeRepository.getEmployee(id);
	}
	
	@POST
	@Path("createemployee")
	public void createEmployee(Employee emp) {
		EmployeeRepository.createEmployee(emp);
	}
	
	@PUT
	@Path("updateemployee")
	public void updateEmployee(Employee emp) {
		EmployeeRepository.updateEmployee(emp);
	}
	
	@DELETE
	@Path("deleteemployee/{id}")
	public void deleteEmployee(@PathParam("id") int id) {
		EmployeeRepository.deleteEmployee(id);
	}
}
