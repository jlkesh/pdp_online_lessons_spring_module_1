package uz.pdp.springframeworkcore.daos;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;
import uz.pdp.springframeworkcore.domains.Uploads;

import java.util.Map;

@Component
public class UploadsDao {
    private final NamedParameterJdbcTemplate template;

    public UploadsDao(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    public void save(Uploads uploads) {
        String sql = "insert into uploads (originalname,generatedname, mimetype, size) values(:originalName, :generatedName, :mimeType, :size)";
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(uploads);
        template.update(sql, paramSource);
    }

    public Uploads findByGenerateName(String filename) {
        String sql = "select * from uploads where generatedName = :generatedName";
        Map<String, Object> paramSource = Map.of("generatedName", filename);
        return template.queryForObject(sql, paramSource, BeanPropertyRowMapper.newInstance(Uploads.class));
    }
}
