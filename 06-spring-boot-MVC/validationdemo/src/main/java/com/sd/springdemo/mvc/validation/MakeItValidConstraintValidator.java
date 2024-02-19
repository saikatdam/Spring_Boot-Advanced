package com.sd.springdemo.mvc.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.lang.annotation.Annotation;

public class MakeItValidConstraintValidator implements ConstraintValidator<MakeItValid,String> {
    private String coursePrefix;

    @Override
    public void initialize(MakeItValid makeItValid) {
        coursePrefix = makeItValid.value();

    }

    @Override
    public boolean isValid(String theCode, ConstraintValidatorContext constraintValidatorContext) {
        boolean result;
        if (theCode != null)
            result = theCode.startsWith(coursePrefix);
        else
            result = true;

        return result;
    }
}