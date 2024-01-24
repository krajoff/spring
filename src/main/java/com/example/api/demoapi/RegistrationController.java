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
@RequestMapping("/registration")
public class RegistrationController {
    private final RegistrationService registrationService;

    @Autowired
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @RequestMapping(params = {"name","age","email"},
            method = RequestMethod.POST)
    public ResponseEntity<User> createUser(
            @RequestParam("name") String name,
            @RequestParam("age") int age,
            @RequestParam("email") String email) {
        return new ResponseEntity<>(registrationService.registrationUser(name, age, email),
                HttpStatus.CREATED);
    }

}
