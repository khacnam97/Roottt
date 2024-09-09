package com.comit.notjpa.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.comit.notjpa.dto.EmployeeDto;
import com.comit.notjpa.entities.Employee;
import com.comit.notjpa.services.EmployeeService;

import groovy.lang.Binding;


@Controller
public class EmployeeController {

	
	@Autowired
    private EmployeeService employeeService;

	@RequestMapping("/")
    public String getEmployees(Model model) {
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);
        return "employees/index";
    }
	
	@RequestMapping(value ="/employee/delete/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<String> deleteEmployees(@PathVariable long id) throws Exception {
		System.out.println("delete");
		try {
			Employee employees = employeeService.deleteEmployees(id);
		} catch (DataAccessException ex) {
			return new ResponseEntity<String>(ex.toString(), HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<String>("Delete_Success", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/employees/edit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable("id") Long id, Model model) {
		Employee employee = employeeService.findEmp(id);
		model.addAttribute("employee", employee);
		return "employees/edit";
	}
	
	@RequestMapping(value = "/employees/edit/{id}", method = RequestMethod.POST)
	public String updateEmployee(@PathVariable("id") Long id, @ModelAttribute("employee") Employee employee) {
		employeeService.updateEmployee(id, employee);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/employees/create", method = RequestMethod.GET)
	public String create(Model model) {
		model.addAttribute("employee", new EmployeeDto());
		return "employees/create";
	}
	
	@RequestMapping(value = "/employees/create", method = RequestMethod.POST)
	public String createEmployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult result, Model model) {
		System.out.println("kakakaka");
		if (result.hasErrors()) {
			model.addAttribute("employee", employee);
	        return "employees/create";
	    }
		employeeService.createEmployee(employee);
		return "redirect:/";
	}
}
