package com.example.api.demoapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Создать сервис "RegistrationService", который принимает на вход данные
// о пользователе (имя, возраст, email), создает пользователя с помощью
// UserService, затем использует DataProcessingService для добавления
// пользователя в список и выполнения операций над этим списком.
// После выполнения каждой операции, использовать NotificationService
// для вывода информации о выполненной операции.

@Service
public class RegistrationService {
    private final UserService userService;
    private final NotificationService notificationService;
    private final DataProcessingService dataProcessingService;

    @Autowired
    public RegistrationService(UserService userService,
                               NotificationService notificationService,
                               DataProcessingService dataProcessingService) {
        this.userService = userService;
        this.notificationService = notificationService;
        this.dataProcessingService = dataProcessingService;
    }

    public User registrationUser(String name, int age, String email) {
        return userService.createUser(name, age, email);
    }


}
