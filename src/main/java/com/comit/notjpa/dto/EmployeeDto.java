package com.comit.notjpa.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.comit.notjpa.dto.validator.UniqueUsername;

@UniqueUsername(username = "last_name")
public class EmployeeDto {
	@Id
    @GeneratedValue
    private Long employee_id;
    private String first_name;
    private String last_name;
    private String email;
    private String job_id;
    
    public Long getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(Long employee_id) {
		this.employee_id = employee_id;
	}
	
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getJob_id() {
		return job_id;
	}
	public void setJob_id(String job_id) {
		this.job_id = job_id;
	}
}
