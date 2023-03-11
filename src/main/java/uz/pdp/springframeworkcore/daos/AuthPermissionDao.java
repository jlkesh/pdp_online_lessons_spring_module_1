package uz.pdp.springframeworkcore.daos;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import uz.pdp.springframeworkcore.domains.AuthPermission;
import uz.pdp.springframeworkcore.domains.AuthRole;
import uz.pdp.springframeworkcore.domains.AuthUser;

import java.util.Collections;
import java.util.List;

@Component
public class AuthPermissionDao {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public AuthPermissionDao(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public List<AuthPermission> findAllByRoleId(@NonNull Long roleID) {
        var sql = "select ap.* from authrole_authpermission arap inner join authpermission ap on ap.id = arap.permission_id where arap.role_id = :roleID";
        var paramSource = new MapSqlParameterSource().addValue("roleID", roleID);
        try {
            return namedParameterJdbcTemplate.query(sql, paramSource, (rs, rowNum) -> AuthPermission.builder()
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
