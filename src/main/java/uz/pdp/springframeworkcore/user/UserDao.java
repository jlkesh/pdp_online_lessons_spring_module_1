package uz.pdp.springframeworkcore.user;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class UserDao {
    private final JdbcTemplate jdbcTemplate;
    private final SimpleJdbcInsert simpleJdbcInsert;

    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
    }

    public void save(User user) {
        var paramSource = new BeanPropertySqlParameterSource(user);
        KeyHolder keyHolder = simpleJdbcInsert.withTableName("users")
                .usingColumns("username", "password", "age")
                .usingGeneratedKeyColumns("id", "created_at")
                .executeAndReturnKeyHolder(paramSource);
        Map<String, Object> keys = keyHolder.getKeys();
        keys.forEach((key, val) -> System.out.println(key + " : " + val));
    }

    public Integer save2(User user) {
        var sql = "insert into users(username, password, age) values (? ,? , ?);";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            var prst = con.prepareStatement(sql, new String[]{"id","created_at"});
            prst.setString(1, user.getUsername());
            prst.setString(2, user.getPassword());
            prst.setInt(3, user.getAge());
            return prst;
        }, keyHolder);
        Number key = keyHolder.getKey();
        Map<String, Object> keys = keyHolder.getKeys();
        return key.intValue();
    }

    public void update(User user) {
        var sql = "update users set username = ?, password = ?, age = ?  where id = ? ;";
        jdbcTemplate.update(sql, user.getUsername(), user.getPassword(), user.getAge(), user.getId());
    }

    public User findById(Integer id) {
        var sql = "select * from users where id = ?;";
        return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(User.class), id);
    }

    public List<User> findAll(int age, int age2) {
        return jdbcTemplate.query(
                "select * from users where age > ? and age < ?",
                BeanPropertyRowMapper.newInstance(User.class),
                age, age2);
    }

    public void delete(Integer id) {
        var sql = "delete from users where id = ? ;";
        jdbcTemplate.update(sql, id);
    }


}
