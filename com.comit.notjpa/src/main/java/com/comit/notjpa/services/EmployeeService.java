package com.comit.notjpa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.comit.notjpa.dao.EmployeeDao;
import com.comit.notjpa.entities.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	
	@Transactional(readOnly = true)
    public List<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }

	@Transactional(readOnly = true)
	public Employee getEmployeeById(Long id) {
		return employeeDao.findByPk(id);
	}
	@Transactional
	public Employee updateEmployee(Long id, Employee employee) {
		Employee curentEmployee = employeeDao.findByPk(id);
		if (curentEmployee != null) {
			curentEmployee.setEmail(employee.getEmail());
			curentEmployee.setFirst_name(employee.getFirst_name());
			curentEmployee.setLast_name(employee.getLast_name());
			curentEmployee.setJob_id(employee.getJob_id());
			return employeeDao.update(curentEmployee);
		}
		
		return null;		
	}
	@Transactional
	public Employee createEmployee(Employee employee) {
		return employeeDao.save(employee);			
	}
	@Transactional
	public void deleteEmployee(Long id) {
		Employee curentEmployee = employeeDao.findByPk(id);
		employeeDao.delete(curentEmployee);		
		//dddd
	}
}
