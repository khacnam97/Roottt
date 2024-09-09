package com.comit.notjpa.dao;

import java.util.List;

import org.springframework.ui.Model;

import com.comit.notjpa.dto.EmployeeDto;
import com.comit.notjpa.entities.Employee;

public interface EmployeeDao {
	
	List<Employee> getAllEmployees();
	
	Employee findByPk(Long id);
	
	Employee update(Employee emp);
	
	Employee delete(Long id);
	
	Employee save(Employee employee);

	Employee edit(Long id, Model model);

}
