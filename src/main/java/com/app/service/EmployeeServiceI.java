package com.app.service;

import java.util.List;

import com.app.model.Employee;

public interface EmployeeServiceI {
	public Employee addEmployee(Employee employee);
   public List<Employee> getAll();
   public Employee updateEmployee(Employee employee);
   public List<Employee>deleteEmployeeData(int id);
   public long countEmployee();
   public Employee getSingleData(int id);
   
   public List<Employee> fingByName(String nm);
   public Employee loginCheck(String un,String ps);
   public List<Employee> deleteEmployeeName(String name);
   
}
