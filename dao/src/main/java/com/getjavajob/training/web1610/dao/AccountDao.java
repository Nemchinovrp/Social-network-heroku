package com.getjavajob.training.web1610.dao;

import com.getjavajob.training.web1610.common.Account;
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
public class AccountDao extends AbstractDao<Account> {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public AccountDao() {
    }

    public Account create(final Account account) throws DaoException {
        return entityManager.merge(account);
    }

    public List<Account> searchAccounts(String search) throws DaoException {
        return entityManager.createQuery(accountCriteriaQuery(search)).getResultList();
    }

    public List<Account> pagination(String search, int start, int page) {
        return entityManager.createQuery(accountCriteriaQuery(search)).setFirstResult(start).setMaxResults(page).getResultList();
    }

    private CriteriaQuery<Account> accountCriteriaQuery(String search) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Account> criteriaQuery = builder.createQuery(Account.class);
        Root<Account> root = criteriaQuery.from(Account.class);
        return criteriaQuery.select(root).where(builder.or(builder.like(builder.lower(root.<String>get("firstName")), "%" + search + "%"), builder.like(builder.lower(root.<String>get("lastName")), "%" + search + "%")));
    }

    public int countSearchResult(String search) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Account> criteriaQuery = builder.createQuery(Account.class);
        Root<Account> root = criteriaQuery.from(Account.class);
        criteriaQuery.select(root).where(builder.or(builder.like(builder.lower(root.<String>get("firstName")), "%" + search + "%"), builder.like(builder.lower(root.<String>get("lastName")), "%" + search + "%")));
        return entityManager.createQuery(criteriaQuery).getResultList().size();
    }

    public Account getByEmail(String email) throws DaoException {
        return getAccount("email", email);
    }

    @Override
    public Account getById(int id) throws DaoException {
        return getAccount("id", id);
    }

    public Account getAccount(String field, Object o) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Account> criteriaQuery = builder.createQuery(Account.class);
        Root<Account> root = criteriaQuery.from(Account.class);
        criteriaQuery.select(root).where(builder.equal(root.get(field), o));
        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }

    @Override
    public List<Account> getAll() throws DaoException {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Account> query = builder.createQuery(Account.class);
        Root<Account> root = query.from(Account.class);
        query.select(root);
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void update(Account account) throws DaoException {
        entityManager.merge(account);
    }

    @Override
    public void delete(int id) throws DaoException {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaDelete<Account> delete = cb.createCriteriaDelete(Account.class);
        Root e = delete.from(Account.class);
        delete.where(cb.lessThanOrEqualTo(e.get("id"), id));
        entityManager.createQuery(delete).executeUpdate();
    }
}