package com.schindler.springjdbcdemo.mapper;

import com.schindler.springjdbcdemo.entitiy.Developer;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class DeveloperRowMapper implements RowMapper<Developer> {

    @Override
    public Developer mapRow(final ResultSet rs, final int rowNum) throws SQLException {

        final Developer developer = new Developer();
        developer.setId(rs.getInt("id"));
        developer.setFirstName(rs.getString("first_name"));
        developer.setLastName(rs.getString("last_name"));
        developer.setEmail(rs.getString("email"));
        developer.setProgrammingLanguage(rs.getString("prog_lang"));

        return developer;
    }
}
