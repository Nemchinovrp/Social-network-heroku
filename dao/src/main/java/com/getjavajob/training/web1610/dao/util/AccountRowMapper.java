package com.getjavajob.training.web1610.dao.util;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRowMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int line) throws SQLException {
        AccountResultSetExtractor extractor = new AccountResultSetExtractor();
        return extractor.extractData(rs);
    }

}