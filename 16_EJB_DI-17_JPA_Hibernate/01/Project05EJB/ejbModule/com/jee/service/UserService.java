package com.jee.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.jee.entity.UserModel;

@Stateless
public class UserService implements UserServiceLocal {
    
    @PersistenceContext
    protected EntityManager entityManager;
    
    public UserService() {}
    
    @SuppressWarnings("unchecked")
    @Override
    public List<UserModel> findAllUsers() {
        String queryString = "select model from UserModel model order by upper(model.username) asc";
        Query query = entityManager.createQuery(queryString);
        
        return query.getResultList();
    }
    
    @Override
    public UserModel save(UserModel entity) {
        entityManager.persist(entity);
        
        return entity;
    }
    
    @Override
    public UserModel update(UserModel entity) {
        entityManager.merge(entity);
        entityManager.flush();
        
        return entity;
    }
    
    @Override
    public void delete(UserModel entity) {
        entityManager.remove(entity);
    }
    
    @Override
    public UserModel findById(Long id) {
        try {
            UserModel instance = entityManager.find(UserModel.class, id);
            
            return instance;
        } catch (RuntimeException re) {
            throw re;
        }
    }
    
    @Override
    public UserModel loginUser(String username, String password) {
        StringBuffer queryString = new StringBuffer("select model from UserModel model where model.username = :un and "
                + "model.password = :p");
        Query query = entityManager.createQuery(queryString.toString());
        query.setParameter("un", username);
        query.setParameter("p", password);
        
        try {
            return (UserModel) query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }
    
    @Override
    public UserModel checkUserExists(String username, Long id) {
        StringBuffer queryString = new StringBuffer("select model from UserModel model where upper(model.username) = "
                + "upper(:un)");
        
        if (id != null) {
            queryString.append(" and model.id <> ").append(id);
        }
        
        Query query = entityManager.createQuery(queryString.toString());
        query.setParameter("un", username);
        
        try {
            return (UserModel) query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }
}