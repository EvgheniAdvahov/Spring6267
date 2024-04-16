package ru.gb.my_first_crud.repository;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.gb.my_first_crud.model.User;

import java.util.List;

@Repository
public class UserRepository {

    private final JdbcTemplate jdbc;

    public UserRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<User> findAll() {
        String sql = "SELECT * FROM userTable";

        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setFirstName(r.getString("firstName"));
            rowObject.setLastName(r.getString("lastName"));
            return rowObject;
        };

        return jdbc.query(sql, userRowMapper);
    }

    public User save(User user) {
        String sql = "INSERT INTO userTable (firstName,lastName) VALUES ( ?, ?)";
        jdbc.update(sql, user.getFirstName(), user.getLastName());
        return  user;
    }

    public User update(User user) {
        String sql = "UPDATE userTable SET firstName = ?, lastName = ?";
        jdbc.update(sql, user.getFirstName(), user.getLastName());
        return user;
    }

    public void deleteById(int id){
        String sql = "DELETE FROM userTable WHERE id=?";
        jdbc.update(sql, id);
        System.out.println("Deleted Record with ID = " + id );
    }

    public User findById(int id) {
        String sql = "SELECT * FROM userTable WHERE id=?";
        try {
            return jdbc.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                System.out.println(user);
                return user;
            });
        }
        catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    //public void deleteById(int id)
    //"DELETE FROM userTable WHERE id=?"
}
