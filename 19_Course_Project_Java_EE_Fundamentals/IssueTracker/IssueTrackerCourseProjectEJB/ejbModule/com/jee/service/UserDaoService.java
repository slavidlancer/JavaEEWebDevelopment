package com.jee.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.jee.entity.UserModel;

@Stateless
public class UserDaoService implements UserDaoServiceLocal {
    
    @PersistenceContext
    protected EntityManager entityManager;
    
    public UserDaoService() {}
    
    @SuppressWarnings("unchecked")
    @Override
    public List<UserModel> findAllUsers() {
        String queryString = "select model from UserModel model order by upper(model.username) asc";
        Query query = entityManager.createQuery(queryString);
        
        return query.getResultList();
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<UserModel> findAllUsersIssuesCount() {
        String queryString = "select new UserModel(usermodel.id, usermodel.username, usermodel.password, "
                + "usermodel.fullName, usermodel.email, COUNT(issuemodel)) "
                + "from UserModel usermodel left join usermodel.issues issuemodel group by usermodel.id "
                + "order by upper(usermodel.username) asc";
        Query query = entityManager.createQuery(queryString);
        
        return query.getResultList();
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
        //entityManager.remove(entity);
        entityManager.remove(entityManager.find(UserModel.class, entity.getId()));
    }
    
    public void deleteById(Long id) {
        entityManager.remove(entityManager.find(UserModel.class, id));
    }
    
    @Override
    public UserModel findUserLogin(String username, String password) {
        StringBuffer queryString = new StringBuffer("select model from UserModel model "
                + "where model.username = :un and model.password = :p");
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
        StringBuffer queryString = new StringBuffer("select model from UserModel model "
                + "where upper(model.username) = upper(:un)");
        
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
