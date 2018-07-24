package com.imooc.firstappdemo.controller;

import com.imooc.firstappdemo.domain.User;
import com.imooc.firstappdemo.domain.WorkInfoForm;
import com.imooc.firstappdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    @PostMapping("/person/save")
    public User save(@RequestParam String name){
        User user = new User();
        user.setName(name);
        if(userRepository.save(user)){
            System.out.printf("用户对象：%s 保存成功!\n", user);
        }

        return user;
    }

    @PostMapping("/addworkinfo.json")
    public void addWorkInfo(@Validated({WorkInfoForm.Add.class}) WorkInfoForm workInfoForm, BindingResult result){
        if (result.hasErrors()){
            List<ObjectError> list = result.getAllErrors();
            FieldError error = (FieldError) list.get(0);
            System.out.println(error.getObjectName() + ","+ error.getField() + "," + error.getDefaultMessage());
            return;
        }else {
            System.out.println("addWorkInfo--");
        }
        return;
    }
}
