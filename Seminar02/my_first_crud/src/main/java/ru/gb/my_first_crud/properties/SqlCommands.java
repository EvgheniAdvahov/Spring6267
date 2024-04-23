package ru.gb.my_first_crud.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "sql")
@Data
public class SqlCommands {
    private String findAll;
    private String insertUser;
    private String deleteById;
    private String findById;
    private String updateUser;
}
