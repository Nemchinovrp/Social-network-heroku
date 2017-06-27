package com.getjavajob.training.web1610.dao;

import com.getjavajob.training.web1610.common.Group;
import com.getjavajob.training.web1610.dao.exception.DaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class GroupDao extends AbstractDao<Group> {
    private AccountDao accountDao;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public GroupDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public Group create(final Group group) throws DaoException {
        return entityManager.merge(group);
    }

    public List<Group> getByName(String name) throws DaoException {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Group> criteriaQuery = builder.createQuery(Group.class);
        Root<Group> root = criteriaQuery.from(Group.class);
        criteriaQuery.select(root).where(builder.or(builder.like(builder.lower(root.<String>get("name")), "%" + name + "%")));
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    public Group getById(int id) throws DaoException {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Group> criteriaQuery = builder.createQuery(Group.class);
        Root<Group> root = criteriaQuery.from(Group.class);
        criteriaQuery.select(root).where(builder.equal(root.get("id"), id));
        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }

    @Override
    public void update(final Group group) throws DaoException {
        entityManager.merge(group);
    }

    @Override
    public void delete(int id) throws DaoException {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaDelete<Group> delete = cb.createCriteriaDelete(Group.class);
        Root e = delete.from(Group.class);
        delete.where(cb.lessThanOrEqualTo(e.get("id"), id));
        entityManager.createQuery(delete).executeUpdate();
    }

    public List<Group> getAll() throws DaoException {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Group> query = builder.createQuery(Group.class);
        Root<Group> root = query.from(Group.class);
        query.select(root);
        return entityManager.createQuery(query).getResultList();
    }
}