package com.comit.notjpa.dto.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = {UsernameUniqueValidator.class})
@Target({ElementType.FIELD, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueUsername {
    String username();
    String message() default "error";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
//	String employeeId();
}
