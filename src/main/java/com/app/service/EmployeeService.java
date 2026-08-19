package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Employee;
import com.app.repository.EmployeeRepository;

@Service
public class EmployeeService implements EmployeeServiceI {
	@Autowired
	private EmployeeRepository er;

	@Override
	public Employee addEmployee(Employee employee) {
		Employee emp = er.save(employee);
		return emp;
	}

	@Override
	public List<Employee> getAll() {
		List<Employee> all = (List<Employee>) er.findAll();// method to retrive all data
		return all;
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		Employee updateData = er.save(employee);
		return updateData;
	}

	@Override
	public List<Employee> deleteEmployeeData(int id) {
		er.deleteById(id);
		List<Employee> delete = (List<Employee>) er.findAll();
		return delete;
	}

	@Override
	public long countEmployee() {

		long count = er.count();

		return count;
	}

	@Override
	public Employee getSingleData(int id) {
		Optional op = er.findById(id); // java1.8 version

		if (op.isPresent()) // to avoid nullpointer exception
		{
			Employee emp = (Employee) op.get();

			return emp;
	 }
		return null;
	}

	@Override
	public List<Employee> fingByName(String nm) {
		List<Employee> list=er.findByName(nm);
		return list;
	}

	@Override
	public Employee loginCheck(String un, String ps) {
		
		//Employee emp =er.findByUsernameAndPassword(un, ps);
		Employee emp =er.findByUsernameOrPassword(un, ps);
		return emp;
	}

	@Override
	public List<Employee> deleteEmployeeName(String name) {
		er.deleteByName(name);
		List<Employee> list=(List<Employee>) er.findAll();
		
		return list;
	}

}
