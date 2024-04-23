package ru.gb.my_first_crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan("ru.gb.my_first_crud.properties")
public class MyFirstCrudApplication {


	public static void main(String[] args) {
		SpringApplication.run(MyFirstCrudApplication.class, args);
	}

}
