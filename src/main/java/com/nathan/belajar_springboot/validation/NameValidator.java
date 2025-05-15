package com.nathan.belajar_springboot.validation;

import com.nathan.belajar_springboot.validation.annotation.ValidName;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NameValidator implements ConstraintValidator<ValidName, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value.equalsIgnoreCase("admin")) {
            return false;
        }

        return true;
    }

}
