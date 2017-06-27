package com.getjavajob.training.web1610.dao.util;

public class ConvertDate {
    public static java.sql.Date convert(java.util.Date javaDate) {
        java.sql.Date sqlDate = null;
        if (javaDate != null) {
            sqlDate = new java.sql.Date(javaDate.getTime());
        }
        return sqlDate;
    }
}