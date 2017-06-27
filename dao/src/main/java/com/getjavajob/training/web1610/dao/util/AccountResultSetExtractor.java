package com.getjavajob.training.web1610.dao.util;


import com.getjavajob.training.web1610.common.Account;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountResultSetExtractor implements ResultSetExtractor {
    @Override
    public Object extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        Account account = new Account();
        account.setId(resultSet.getInt(1));
        account.setFirstName(resultSet.getString(2));
        account.setMiddleName(resultSet.getString(3));
        account.setLastName(resultSet.getString(4));
        account.setDateOfBirth(resultSet.getDate(5));
        account.setHomeAddress(resultSet.getString(6));
        account.setWorkingAddress(resultSet.getString(7));
        account.setEmail(resultSet.getString(8));
        account.setPassword(resultSet.getString(9));
        account.setIcq(resultSet.getString(10));
        account.setSkype(resultSet.getString(11));
        account.setInfo(resultSet.getString(12));
        account.setFoto(resultSet.getBytes(13));
        return account;
    }
}
