package com.imooc.firstappdemo.constraint;

import com.imooc.firstappdemo.constraint.WorkOverTime;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class WorkOverTimeValidator implements ConstraintValidator<WorkOverTime, Integer> {
    WorkOverTime work;
    int max;
    @Override
    public void initialize(WorkOverTime constraintAnnotation) {
        //获取注解定义
        this.work = constraintAnnotation;
        max = work.max();
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        //校验逻辑
        if(value == null){
            return true;
        }
        return false;
    }
}
