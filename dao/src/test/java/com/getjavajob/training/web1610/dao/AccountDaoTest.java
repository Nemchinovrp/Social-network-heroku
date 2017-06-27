package com.getjavajob.training.web1610.dao;

import com.getjavajob.training.web1610.common.Account;
import com.getjavajob.training.web1610.dao.exception.DaoException;
import org.h2.tools.RunScript;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.GregorianCalendar;
import java.util.List;

import static junit.framework.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:dao-context.xml", "classpath:dao-context-overrides.xml"})
public class AccountDaoTest {
    @Autowired
    private AccountDao accountDao;
    @Autowired
    private DataSource dataSource;
    private Account accountCreateFroTest;
    private Account test1;
    private Account test2;

    @Before
    public void init() throws FileNotFoundException, SQLException {
        File file = new File(new AccountDaoTest().getClass().getResource("/create.sql").getPath());
        Reader reader = new FileReader(file);
        try (Connection connection = dataSource.getConnection();) {
            RunScript.execute(connection, reader);
        } catch (Exception e) {
            System.err.println(e);
        }
        accountCreateFroTest = new Account(4, "testFirst", "test", "test", new GregorianCalendar(1991, 2, 11).getTime(), "test", "test", "test", "test", "test", "test", "test");
        test1 = new Account(11, "test", "test", "test", "test");
        test2 = new Account(13, "test", "test", "test", "test");
    }

    @Test
    @Transactional
    public void createTestAccount() throws DaoException {
        accountDao.create(accountCreateFroTest);
        assertEquals("testFirst", accountDao.getById(4).getFirstName());
    }

    @Test
    @Transactional
    public void testSearchAccounts() throws DaoException {
        accountDao.create(test1);
        List<Account> result = accountDao.searchAccounts("es");
        assertEquals(1, result.size());
    }

    @Test
    @Transactional
    public void testPagination() throws DaoException {
        Account account1 = new Account(10, "Roman", "Nemchinov");
        Account account2 = new Account(11, "Roman", "Nemchinov");
        Account account3 = new Account(12, "Roman", "Nemchinov");
        accountDao.create(account1);
        accountDao.create(account2);
        accountDao.create(account3);
        List<Account> result = accountDao.pagination("ov", 2, 3);
        System.out.println(result.size());
        assertEquals(2, result.size());
    }

    @Test
    @Transactional
    public void countSearchResult() throws DaoException {
        Account account1 = new Account(10, "Roman", "Nemchinov");
        Account account2 = new Account(11, "Roman", "Nemchinov");
        accountDao.create(account1);
        accountDao.create(account2);
        assertEquals(2, accountDao.countSearchResult("oma"));
    }

    @Test
    @Transactional
    public void createAccount() throws DaoException {
        accountCreateFroTest = new Account("testFirst", "test", "test", new GregorianCalendar(1991, 2, 11).getTime(), "test", "test", "test", "test", "test", "test", "test");
        accountDao.create(accountCreateFroTest);
        assertEquals("testFirst", accountDao.getById(4).getFirstName());
    }

    @Test
    public void testGetByEmail() throws DaoException {
        Account expected = accountDao.getByEmail("lastemperor@gmail.ru");
        assertEquals("123", expected.getPassword());
    }

    @Test
    public void getByIdTestAccount() throws DaoException {
        Account expected = accountDao.getAll().get(0);
        assertEquals(expected, accountDao.getById(1));
    }

    @Test
    public void testGetAll() throws DaoException {
        assertEquals(3, accountDao.getAll().size());
    }

    @Test
    @Transactional
    public void testUpdateAccount() throws DaoException {
        Account accountUpdate = new Account(4, "update", "update", "update", new GregorianCalendar(1991, 2, 11).getTime(), "update", "update", "update", "update", "update", "update", "update");
        accountDao.create(accountCreateFroTest);
        accountDao.update(accountUpdate);
        assertEquals("update", accountDao.getById(4).getFirstName());
    }

    @Test
    @Transactional
    public void testDeleteAccount() throws DaoException {
        accountDao.create(accountCreateFroTest);
        accountDao.delete(4);
    }
}