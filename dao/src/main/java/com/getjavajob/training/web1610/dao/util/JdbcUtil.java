package com.getjavajob.training.web1610.dao.util;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcUtil {
    public static void close(ResultSet resultSet) {
        try {
            if (resultSet != null && !resultSet.isClosed()) {
                try {
                    resultSet.close();
                } catch (Exception e) {
                    e.getMessage();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}