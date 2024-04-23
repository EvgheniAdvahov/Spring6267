package ru.gb.my_first_crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource({"classpath:sql.properties", "classpath:application.properties"})
//@ConfigurationPropertiesScan("ru.gb.my_first_crud.properties") //лучше когда много класов
public class MyFirstCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyFirstCrudApplication.class, args);
    }

}
