package com.startup.controller;

import com.startup.entity.User;
import com.startup.factory.UserFactory;
import com.startup.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;



    @RequestMapping("/list")
    public ModelAndView list(){
        ModelAndView model = new ModelAndView("user_list");
        Set<User> userSet = userService.getAll();
        model.addObject("userSet", userSet);
        return model;
    }


    @PostMapping("/create")
    public User create(@RequestBody User user){
        User newUser = UserFactory.createUser(user.getUsername(), user.getPassword(), user.getName(), user.getSurname(), user.getCellNo(), user.getEmailAddress());
        return  userService.create(newUser);
    }

    @GetMapping("/read/{id}")
    public User read(@PathVariable String id) {
        return userService.read(id);
    }

    @PostMapping("/update")
    public User update(@RequestBody User user) {
        return userService.update(user);
    }

    @GetMapping("/all")
    public Set<User> getall(){
        return userService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){
        return userService.delete(id);
    }
}
