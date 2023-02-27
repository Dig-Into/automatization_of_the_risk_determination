package com.aord.aord.api.annotations.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.aord.aord.api.annotations.Email;

public class EmailValidator implements ConstraintValidator<Email, String>{

    @Override
    public void initialize(Email emailToBeValidated) {
        // Should not be overwritten
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        final String regex = "^(.+)@(.+)$";
        return value != null && value.matches(regex);
    }

}