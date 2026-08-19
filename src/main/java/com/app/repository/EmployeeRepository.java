package com.app.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.model.Employee;
import java.util.List;


@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Integer>
{
public List<Employee> findByName(String name);
//public Employee findByUsernameAndPassword(String un,String ps);
public Employee findByUsernameOrPassword(String un,String ps);

@Transactional
@Modifying
public void deleteByName(String name);
	
	
	
}
