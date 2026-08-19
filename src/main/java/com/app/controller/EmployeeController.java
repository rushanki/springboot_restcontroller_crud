package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Employee;
import com.app.service.EmployeeServiceI;

@RestController
public class EmployeeController {
    
	@Autowired
	private EmployeeServiceI esi;
	
	@PostMapping("/employee")
	public Employee saveEmployee(@RequestBody Employee employee)
	{
		Employee emp = esi.addEmployee(employee);
		return emp;
	}
	@GetMapping("/get")
	public List<Employee>getAllEmployee() //to getall data so list 
	{
		List<Employee>all=esi.getAll();
		return all;
	}
	@PutMapping("/update")
	public Employee updateEmployeedata(@RequestBody Employee employee)
	{
		Employee updateEmployeedata=esi.updateEmployee(employee);
		return updateEmployeedata;
	}
	@DeleteMapping("/delete/{id}")
	public List<Employee> deleteEmployee(@PathVariable("id")int id)
	{
	 List<Employee> data=esi.deleteEmployeeData(id);
	return data;
	}
	
	@GetMapping("/count")
	public long employeeCount()
	{
		long count =esi.countEmployee();
		return count;
	}
	@GetMapping("/single/{id}")
	public Employee getSingledata(@PathVariable("id")int id)
	{
       Employee e1 =esi.getSingleData(id);
       return e1;
	}
	
	@GetMapping("/emp/{name}")
	public List<Employee> getEmployeeName(@PathVariable("name")String name)
	{
	    	List<Employee> list =esi.fingByName(name);
	    	return list;
	}
	
	@GetMapping("/login/{username}/{password}")
	public Employee loginCheck(@PathVariable("username")String un,@PathVariable("password")String ps)
	{
		Employee e1= esi.loginCheck(un, ps);
		return e1;
	}
	@DeleteMapping("deletebyname/{name}")
	public List<Employee> deleteEmployee(@PathVariable("name")String name)
	{
		List<Employee>list=esi.deleteEmployeeName(name);
		return list;
	}
	
}
