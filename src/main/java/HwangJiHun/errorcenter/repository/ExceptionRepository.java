package HwangJiHun.errorcenter.repository;

import HwangJiHun.errorcenter.model.MyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Repository
public class ExceptionRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final SimpleJdbcInsert jdbcInsert;


    public ExceptionRepository(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        this.jdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("EXCEPTIONS")
                .usingGeneratedKeyColumns("id");
    }

    public MyException save(MyException myException) {
        SqlParameterSource param = new BeanPropertySqlParameterSource(myException);
        Number key = jdbcInsert.executeAndReturnKey(param);
        myException.setId(key.longValue());

        return myException;
    }

    public Optional<MyException> findById(Long id) {
        String sql = "SELECT * FROM EXCEPTIONS WHERE id = :id";

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("id", id);

        try {
            MyException myException = jdbcTemplate.queryForObject(sql, param, myExceptionRowMapper());
            return Optional.of(myException);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    public Optional<MyException> findByProjectIdLimit1(int projectId) {
        String sql = "SELECT * FROM exceptions WHERE project_id = :projectId ORDER BY project_id DESC LIMIT 1";
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("projectId", projectId);
        try {
            MyException findException = jdbcTemplate.queryForObject(sql, param, myExceptionRowMapper());
            return Optional.of(findException);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }

    }

    private static BeanPropertyRowMapper<MyException> myExceptionRowMapper() {
        return new BeanPropertyRowMapper<>(MyException.class);
    }
}
