package ru.gb.example3_sem3.controllersH2;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.gb.example3_sem3.domain.User;
import ru.gb.example3_sem3.servicesH2.DataProcessingServiceH2;

import java.util.List;

@Controller
@RequestMapping("/h2users")
public class UserControllerH2 {

    private final DataProcessingServiceH2 dataProcessingServiceH2;

    public UserControllerH2(DataProcessingServiceH2 dataProcessingServiceH2) {
        this.dataProcessingServiceH2 = dataProcessingServiceH2;
    }

    @GetMapping
    @ResponseBody
    public List<User> userListH2() {
        return dataProcessingServiceH2.findAllH2();
    }

    @PostMapping("/body")
    public String userAddFromBodyH2(@RequestBody User user) {
        dataProcessingServiceH2.addUserH2(user);
        return "User added to database";
    }

    @PostMapping("/create/{name}/{age}/{email}")
    public ResponseEntity<String> userAddFromParamH2(
            @PathVariable("name") String name
            , @PathVariable("age") int age
            , @PathVariable("email") String email) {
        dataProcessingServiceH2.processRegistrationH2(name, age, email);
        return ResponseEntity.ok("User created successfully");
    }


}
