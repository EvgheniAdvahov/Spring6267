package ru.gb.example3_sem3.repositoryH2;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.gb.example3_sem3.domain.User;

import java.util.List;

@Repository
public class UserRepositoryH2 {

    private final JdbcTemplate jdbc;

    public UserRepositoryH2(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<User> getUsersH2() {
        String sql = "SELECT * FROM userTable";

        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setName(r.getString("firstName"));
            rowObject.setAge(r.getInt("age"));
            rowObject.setEmail(r.getString("email"));
            return rowObject;
        };

        return jdbc.query(sql, userRowMapper);
    }

    public User addToH2(User user) {
        String sql = "INSERT INTO userTable (firstName, age, email) VALUES (?, ?, ?);";
        jdbc.update(sql, user.getName(), user.getAge(), user.getEmail());
        return user;
    }

}
