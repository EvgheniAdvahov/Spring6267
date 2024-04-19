package ru.gb.example3_sem3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.example3_sem3.domain.User;

@Service
public class RegistrationService {

    @Autowired
    private  DataProcessingService dataProcessingService;

    @Autowired
    private UserService userService;

    @Autowired
    private NotificationService notificationService;

    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }

    //Поля UserService, NotificationService

    public void processRegistration(String name, int age, String email){
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setEmail(email);

//        getDataProcessingService().getRepository().getUsers().add(user);
        getDataProcessingService().addUserToList(user);

        notificationService.sendNotification("Пользователь зарегистрирован: " + name);
    }
}
