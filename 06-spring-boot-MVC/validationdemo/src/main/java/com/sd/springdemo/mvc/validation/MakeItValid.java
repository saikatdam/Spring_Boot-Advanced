package com.sd.springdemo.mvc.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = MakeItValidConstraintValidator.class)
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MakeItValid {
    public String value() default "sdCode";
    public String  message() default "The starting must have sdCode";
  public Class<?>[] groups() default {};
  public Class<? extends Payload>[] payload() default {};
}
