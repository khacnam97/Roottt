package com.comit.notjpa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.comit.notjpa.entities.Employee;
import com.comit.notjpa.services.EmployeeService;


@Controller
public class HomeController {

	
	@Autowired
    private EmployeeService employeeService;

	@RequestMapping("/employees")
    public String getEmployees(Model model) {
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);
        return "employees";
    }
	
	@RequestMapping(value = "/employees/{id}/edit", method = RequestMethod.GET)
	public String showEditForm(@PathVariable("id") Long id, Model model) {
		Employee employee = employeeService.getEmployeeById(id);
		model.addAttribute("employee", employee);
		return "form";
	}

	@RequestMapping(value = "/employees/{id}/edit", method = RequestMethod.POST)
	public String updateEmployee(@PathVariable("id") Long id, @ModelAttribute("employee") Employee employee) {
		employeeService.updateEmployee(id, employee);
		return "redirect:/employees";
	}

	@RequestMapping(value = "/employees/create", method = RequestMethod.GET)
	public String showCreateForm(Model model) {
		model.addAttribute("employee", new Employee());
		return "formCreate";
	}

	@RequestMapping(value = "/employees/create", method = RequestMethod.POST)
	public String createEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.createEmployee(employee);
		return "redirect:/employees";
	}

	@RequestMapping("/employees/{id}/delete")
	public String deleteProduct(@PathVariable("id") Long id) {
		employeeService.deleteEmployee(id);
		return "redirect:/employees";
	}
}
