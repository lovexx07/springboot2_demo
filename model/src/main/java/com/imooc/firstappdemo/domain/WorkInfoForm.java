package com.imooc.firstappdemo.domain;

import com.imooc.firstappdemo.constraint.WorkOverTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

public class WorkInfoForm {

    public interface Update{}

    public interface Add{}

    @NotNull(groups = {Update.class})
    @Null(groups = {Add.class})
    Long id;

    @WorkOverTime(max =2)
    int workTime;

    @Size(min = 3, max = 20)
    String name;
    @Email
    String email;
}
