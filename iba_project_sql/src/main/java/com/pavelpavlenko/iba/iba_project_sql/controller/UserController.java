package com.pavelpavlenko.iba.iba_project_sql.controller;

import java.util.List;

import com.pavelpavlenko.iba.iba_project_sql.model.User;
import com.pavelpavlenko.iba.iba_project_sql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")

@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})

public class UserController {

    @Autowired(required = true)
    UserService ser;

    @GetMapping("/user")
    public List<User> getUsers(){
        return ser.getUsers();
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable int id){
        return ser.getUser(id);
    }

    @PostMapping("/user")
    public User addUser(@RequestBody User u){
        return ser.addUser(u);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable int id){
        ser.deleteUser(id);
    }

    @PutMapping("/user")
    public User updateUser(@RequestBody User u){
        return ser.addUser(u);
    }

}

