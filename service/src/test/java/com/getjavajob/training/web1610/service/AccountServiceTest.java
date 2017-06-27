package com.getjavajob.training.web1610.service;

import com.getjavajob.training.web1610.common.Account;
import com.getjavajob.training.web1610.dao.AccountDao;
import com.getjavajob.training.web1610.dao.exception.DaoException;
import com.getjavajob.training.web1610.service.exception.ServiceException;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class AccountServiceTest {
    private AccountDao accountDao;

    private AccountService accountService;
    private Account test = new Account(2, "petya", "petrov", "123456", "1234566");
    private Account test2 = new Account(4, "test", "test", "654321", "654321");

    @Before
    public void init() throws Exception {
        accountDao = mock(AccountDao.class);

        accountService = new AccountService(accountDao);
    }

    /*@Test
    public void createTestService() throws DaoException, ServiceException {
        when(accountDao.create(test)).thenReturn(true);
        assertNotNull(accountService.createAccount(test));
    }*/

    @Test
    public void testDeleteAccountService() throws ServiceException, DaoException {
        accountService.deleteAccount(2);
        verify(accountDao).delete(2);
    }

    @Test
    public void testUpdateAccountService() throws ServiceException, DaoException {
        accountService.updateAccount(test);
        verify(accountDao).update(test);
    }

    @Test
    public void testReturnListAccounts() throws ServiceException, DaoException {
        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account(2, "test", "petrov", "mail@mail.com", "1234566"));
        accounts.add(new Account(3, "test", "petrov", "gmail@gmail.com", "1234566"));
        accounts.add(new Account(4, "test", "petrov", "ya@ya.ru", "1234566"));
        when(accountDao.getAll()).thenReturn(accounts);
        assertEquals(accountService.getAllAccount(), accounts);
    }
}