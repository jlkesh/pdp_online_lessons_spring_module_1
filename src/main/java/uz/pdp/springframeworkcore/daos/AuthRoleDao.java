package uz.pdp.springframeworkcore.daos;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import uz.pdp.springframeworkcore.domains.AuthRole;
import uz.pdp.springframeworkcore.domains.AuthUser;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class AuthRoleDao {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public AuthRoleDao(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public List<AuthRole> findAllByUserId(@NonNull Long userID) {
        var sql = "select ar.* from authuser_authrole auar inner join authrole ar on ar.id = auar.role_id where auar.user_id = :userID";
        var paramSource = new MapSqlParameterSource().addValue("userID", userID);
        try {
            return namedParameterJdbcTemplate.query(sql, paramSource, (rs, rowNum) -> AuthRole.builder()
                    .id(rs.getLong("id"))
                    .name(rs.getString("name"))
                    .code(rs.getString("code"))
                    .build());

        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
