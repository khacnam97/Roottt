package com.comit.notjpa.dto.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.comit.notjpa.dao.EmployeeDao;
import com.comit.notjpa.entities.Employee;

public class UsernameUniqueValidator implements ConstraintValidator<UniqueUsername, Object>{

	@Autowired
	private EmployeeDao employeeDao;
	

    private String last_name;
    
	@Override
	public void initialize(UniqueUsername constraintAnnotation) {
        this.last_name = constraintAnnotation.username();
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		Employee userDto = (Employee) value;
		Employee user = employeeDao.findByPk(userDto.getEmployee_id());
        if (user == null) {
            return true;
        }
        boolean isValid = user.getEmployee_id().equals(userDto.getEmployee_id());
        if(!isValid){
        	context.disableDefaultConstraintViolation();
        	context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
                    .addPropertyNode( "last_name" ).addConstraintViolation();
        }

        return isValid;
	}

	

}
