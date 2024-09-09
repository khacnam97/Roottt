package com.comit.notjpa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.comit.notjpa.dao.EmployeeDao;
import com.comit.notjpa.dto.EmployeeDto;
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
    public Employee deleteEmployees(Long id) {
        return employeeDao.delete(id);
    }

	public Employee edit(Long id, Model model) {
		return employeeDao.edit(id, model);
	}

	@Transactional(readOnly = true)
	public Employee findEmp(Long id) {
		return employeeDao.findByPk(id);
	}

	@Transactional
	public Employee updateEmployee(Long id, Employee emp) {
		Employee curentEmp = employeeDao.findByPk(id);
		if (curentEmp != null) {				
			curentEmp.setFirst_name(emp.getFirst_name());
			curentEmp.setLast_name(emp.getLast_name());
			return employeeDao.update(curentEmp);
		}
		return null;	
	}

	@Transactional
	public Employee createEmployee(Employee employee) {
		return employeeDao.save(employee);
	}
}
