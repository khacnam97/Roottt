package com.comit.notjpa.dao;

import java.util.List;

import com.comit.notjpa.entities.Employee;

public interface EmployeeDao {
	
	List<Employee> getAllEmployees();
	
	Employee findByPk(Long id);
	
	Employee update(Employee employee);
	
	void delete(Employee employee);
	
	Employee save(Employee employee);

}
