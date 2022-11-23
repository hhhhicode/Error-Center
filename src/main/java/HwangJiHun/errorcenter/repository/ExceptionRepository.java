package HwangJiHun.errorcenter.repository;

import HwangJiHun.errorcenter.model.MyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Slf4j
@Repository
public class ExceptionRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final SimpleJdbcInsert jdbcInsert;


    public ExceptionRepository(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        this.jdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("EXCEPTIONS");
    }

    public MyException save(MyException myException) {
        SqlParameterSource param = new BeanPropertySqlParameterSource(myException);
        System.out.println("param = " + param);
        jdbcInsert.execute(param);

        return myException;
    }
}
