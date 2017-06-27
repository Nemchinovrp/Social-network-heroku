package com.getjavajob.training.web1610.service;

import com.getjavajob.training.web1610.common.Account;
import com.getjavajob.training.web1610.dao.AccountDao;
import com.getjavajob.training.web1610.dao.exception.DaoException;
import com.getjavajob.training.web1610.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccountService {
    private AccountDao accountDao;

    public AccountService() {
    }

    @Autowired
    public AccountService(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Transactional
    public Account createAccount(Account account) throws ServiceException {
        try {
            return accountDao.create(account);
        } catch (DaoException e) {
            throw new ServiceException("Failed create Account from service layer", e);
        }
    }

    @Transactional
    public void updateAccount(Account account) throws ServiceException {
        try {
            accountDao.update(account);
        } catch (DaoException e) {
            throw new ServiceException("Failed update Account from service layer", e);
        }
    }

    public Account getById(int id) throws ServiceException {
        try {
            return accountDao.getById(id);
        } catch (DaoException e) {
            throw new ServiceException("Failed return  Account from service layer", e);
        }
    }

    public List<Account> getSearchAccount(String search) throws ServiceException {
        try {
            return accountDao.searchAccounts(search);
        } catch (DaoException e) {
            throw new ServiceException("Failed return list serches accounts from service layer", e);
        }
    }

    @Transactional
    public List<Account> pagination(String search, int start, int page) {
        return accountDao.pagination(search, start, page);
    }

    @Transactional
    public int countSearchResult(String search) {
        return accountDao.countSearchResult(search);
    }

    @Transactional
    public Account getByEmail(String email) throws ServiceException {
        try {
            Account account = accountDao.getByEmail(email);
            return account;
        } catch (DaoException e) {
            throw new ServiceException("Failed return  Account from service layer", e);
        }
    }

    @Transactional
    public void deleteAccount(int id) throws ServiceException {
        try {
            accountDao.delete(id);
        } catch (DaoException e) {
            throw new ServiceException("Failed dalete Account from service layer", e);
        }
    }

    public List<Account> getAllAccount() throws ServiceException {
        try {
            return accountDao.getAll();
        } catch (DaoException e) {
            throw new ServiceException("Failed return list Account from service layer", e);
        }
    }
}