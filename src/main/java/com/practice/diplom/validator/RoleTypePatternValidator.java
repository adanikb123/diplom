package com.practice.diplom.validator;

import com.practice.diplom.entity.enums.RoleType;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;

public class RoleTypePatternValidator implements ConstraintValidator<RoleTypeSubSet, RoleType> {
    private RoleType[] subset;
    @Override
    public void initialize(RoleTypeSubSet constraintAnnotation) {
        this.subset = constraintAnnotation.anyOf();
    }

    @Override
    public boolean isValid(RoleType value, ConstraintValidatorContext context) {
        return value == null || Arrays.asList(subset).contains(value);
    }


}
