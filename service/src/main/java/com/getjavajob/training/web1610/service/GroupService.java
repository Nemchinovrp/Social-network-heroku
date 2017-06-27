package com.getjavajob.training.web1610.service;

import com.getjavajob.training.web1610.common.Group;
import com.getjavajob.training.web1610.dao.GroupDao;
import com.getjavajob.training.web1610.dao.exception.DaoException;
import com.getjavajob.training.web1610.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {
    private GroupDao groupDao;

    @Autowired
    public GroupService(GroupDao groupDao) {
        this.groupDao = groupDao;
    }

    public Group create(Group group) throws ServiceException {
        try {
            return groupDao.create(group);
        } catch (DaoException e) {
            throw new ServiceException("Failed create group ", e);
        }
    }

    public List<Group> getSearchGroup(String search) throws ServiceException {
        try {
            return groupDao.getByName(search);
        } catch (DaoException e) {
            throw new ServiceException("Failed serch group", e);
        }
    }

    public void update(Group group) throws ServiceException {
        try {
            groupDao.update(group);
        } catch (DaoException e) {
            throw new ServiceException("Failed update group ", e);
        }
    }

    public void delete(int id) throws ServiceException {
        try {
            groupDao.delete(id);
        } catch (DaoException e) {
            throw new ServiceException("Failed delete group ", e);
        }
    }

    public List<Group> getAllGroup() throws ServiceException {
        try {
            return groupDao.getAll();
        } catch (DaoException e) {
            throw new ServiceException("Failed getAll group ", e);
        }
    }

    public Group getById(int id) throws ServiceException {
        try {
            return groupDao.getById(id);
        } catch (DaoException e) {
            throw new ServiceException("Failed getbyid group ", e);
        }
    }
}
