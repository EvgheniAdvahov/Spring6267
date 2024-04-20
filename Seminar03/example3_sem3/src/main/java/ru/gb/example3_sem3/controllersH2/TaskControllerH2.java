package ru.gb.example3_sem3.controllersH2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.example3_sem3.domain.User;
import ru.gb.example3_sem3.servicesH2.DataProcessingServiceH2;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/h2tasks")
public class TaskControllerH2 {

    @Autowired
    private DataProcessingServiceH2 dataProcessingServiceH2;

    @GetMapping
    public List<String> getAllTasks() {
        List<String> tasks = new ArrayList<>();
        tasks.add("sort");
        tasks.add("filter");
        tasks.add("calc");
        return tasks;
    }

    @GetMapping("/sort")
    public List<User> sortUsersByAge() {
        return dataProcessingServiceH2.sortUsersByAgeH2(dataProcessingServiceH2.findAllH2());
    }

    @GetMapping("/filter/{age}")
    public List<User> filterByAge(@PathVariable("age") int age) {
        return dataProcessingServiceH2.filterUsersByAgeH2(dataProcessingServiceH2.findAllH2(), age);
    }

    @GetMapping("/calc")
    public Double averageAge() {
        return dataProcessingServiceH2.calculateAverageAgeH2(dataProcessingServiceH2.findAllH2());
    }


}
