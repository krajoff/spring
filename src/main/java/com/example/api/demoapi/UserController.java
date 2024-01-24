package com.example.api.demoapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(params = {"name", "age", "email"},
            method = RequestMethod.POST)
    public ResponseEntity<User> createUser(
            @RequestParam("name") String name,
            @RequestParam("age") int age,
            @RequestParam("email") String email) {
        return new ResponseEntity<>(userService.createUser(name, age, email),
                HttpStatus.CREATED);
    }

}
