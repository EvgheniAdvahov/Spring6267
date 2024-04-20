package ru.gb.example3_sem3.servicesH2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.example3_sem3.domain.User;
import ru.gb.example3_sem3.repositoryH2.UserRepositoryH2;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataProcessingServiceH2 {

    @Autowired
    private UserRepositoryH2 userRepositoryH2;
    @Autowired
    private NotificationServiceH2 notificationServiceH2;


    public List<User> findAllH2() {
        return userRepositoryH2.getUsersH2();
    }

    public User addUserH2(User user) {
        return userRepositoryH2.addToH2(user);
    }

    public void processRegistrationH2(String name, int age, String email) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setEmail(email);

        userRepositoryH2.addToH2(user);
//        addUserH2(user);
        notificationServiceH2.sendNotificationH2("Пользователь зарегистрирован: " + name);

    }

    public List<User> sortUsersByAgeH2(List<User> users) {
        return users.stream()
                .sorted(Comparator.comparing(User::getAge))
                .collect(Collectors.toList());
    }

    public List<User> filterUsersByAgeH2(List<User> users, int age) {
        return users.stream()
                .filter(user -> user.getAge() > age)
                .collect(Collectors.toList());
    }

    public Double calculateAverageAgeH2(List<User> users) {
        return users.stream()
                .mapToInt(User::getAge)
                .average()
                .orElse(0);
    }
}
