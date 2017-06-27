package com.getjavajob.training.web1610.dao;

import com.getjavajob.training.web1610.dao.exception.DaoException;

import java.sql.SQLException;
import java.util.List;

public abstract class AbstractDao<T> {

    abstract T create(T t) throws DaoException, InterruptedException, SQLException;

    abstract T getById(int id) throws DaoException;

    abstract void update(T t) throws DaoException;

    abstract void delete(int id) throws DaoException;

    abstract List<T> getAll() throws DaoException;
}
