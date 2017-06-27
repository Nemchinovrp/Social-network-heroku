package com.getjavajob.training.web1610.dao;

import com.getjavajob.training.web1610.common.Group;
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

import static junit.framework.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:dao-context.xml", "classpath:dao-context-overrides.xml"})
public class GroupDaoTest {
    @Autowired
    private GroupDao groupDao;
    @Autowired
    private DataSource dataSource;
    @Autowired
    private AccountDao accountDao;
    private Group groupForTest;

    public GroupDaoTest() throws DaoException {
    }

    @Before
    public void init() throws FileNotFoundException, SQLException, DaoException {
        groupForTest = new Group(4, "test", accountDao.getById(1), "info");
        File file = new File(new GroupDaoTest().getClass().getResource("/create.sql").getPath());
        Reader reader = new FileReader(file);
        try (Connection connection = dataSource.getConnection()) {
            RunScript.execute(connection, reader);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    @Test
    @Transactional
    public void createGroupTest() throws DaoException {
        groupDao.create(groupForTest);
        assertEquals(4, groupDao.getById(4).getId());
    }

    @Test
    public void getByIdGroupTest() throws DaoException {
        assertEquals(3, groupDao.getById(3).getId());
    }

    @Test
    public void getSearchByName() throws DaoException {
        assertEquals(1, groupDao.getByName("ua").size());
    }

    @Test
    @Transactional
    public void updateGroupTest() throws DaoException {
        Group groupUpdate = new Group(3, "update", accountDao.getById(1), "info");
        System.out.println(groupDao.getById(3));
        groupDao.update(groupUpdate);
        System.out.println(groupDao.getById(3));
        assertEquals("update", groupDao.getById(3).getName());
    }

    @Test
    @Transactional
    public void getAllTest() throws DaoException {
        assertEquals(3, groupDao.getAll().size());
    }

    @Test
    @Transactional
    public void testDeleteGroup() throws DaoException {
        groupDao.create(groupForTest);
        groupDao.delete(4);
    }
}