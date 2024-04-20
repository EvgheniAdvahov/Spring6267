package ru.gb.example3_sem3.servicesH2;

import org.springframework.stereotype.Service;

@Service
public class NotificationServiceH2 {

    public void sendNotificationH2(String s){
        System.out.println(s);
    }

}
