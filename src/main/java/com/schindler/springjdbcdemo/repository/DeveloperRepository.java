package com.schindler.springjdbcdemo.repository;

import com.schindler.springjdbcdemo.entitiy.Developer;
import com.schindler.springjdbcdemo.mapper.DeveloperRowMapper;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Data
@RequiredArgsConstructor
@Repository
public class DeveloperRepository {

    private final JdbcTemplate jdbcTemplate;
    private final DeveloperRowMapper developerRowMapper;

    @PostConstruct
    public void initDb() {
        String sql = """
            CREATE TABLE IF NOT EXISTS developer(
                id SERIAL PRIMARY KEY,
                first_name VARCHAR(20) NOT NULL,
                last_name VARCHAR(20) NOT NULL,
                email VARCHAR(50) NOT NULL,
                prog_lang VARCHAR(20) NOT NULL
            );
            """;
        jdbcTemplate.execute(sql);
    }

    @Transactional
    public int save(final Developer developer) {
        final String sql = "insert into developer (first_name, last_name, email, prog_lang) values (?, ?, ?, ?)";
        return jdbcTemplate.update(
                sql,
                developer.getFirstName(),
                developer.getLastName(),
                developer.getEmail(),
                developer.getProgrammingLanguage()
        );
    }

    @Transactional
    public List<Developer> findAll() {
        final String sql = "select * from developer";
        return jdbcTemplate.query(sql, developerRowMapper);
    }

    @Transactional
    public Developer findById(final long id) {
        final String sql = "select * from developer where id = ?";
        return jdbcTemplate.queryForObject(sql, developerRowMapper, id);
    }
}
