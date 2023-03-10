package uz.pdp.springframeworkcore.user;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.util.List;
import java.util.Map;

public class UserDao2 {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public UserDao2(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public void save(User user) {
        var sql = "insert into users(username, password, age) values (:username ,:password , :age);";
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(user);
        namedParameterJdbcTemplate.update(sql, paramSource);
    }


    public Integer save2(User user) {
        var sql = "insert into users(username, password, age) values (:username ,:password , :age);";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        SqlParameterSource paramSource = new MapSqlParameterSource()
                .addValue("username", user.getUsername())
                .addValue("password", user.getPassword())
                .addValue("age", user.getAge());
        namedParameterJdbcTemplate.update(sql, paramSource, keyHolder, new String[]{"id"});
        return (Integer) keyHolder.getKeys().get("id");
    }

    /*

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

*/

}
