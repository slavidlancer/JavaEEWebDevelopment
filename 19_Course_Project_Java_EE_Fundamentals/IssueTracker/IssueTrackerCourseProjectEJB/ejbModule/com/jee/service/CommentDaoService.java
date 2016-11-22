package com.jee.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.jee.entity.CommentModel;

@Stateless
public class CommentDaoService implements CommentDaoServiceLocal {
    
    @PersistenceContext
    protected EntityManager entityManager;
    
    public CommentDaoService() {}
    
    @SuppressWarnings("unchecked")
    @Override
    public List<CommentModel> findAllComments() {
        String queryString = "select model from CommentModel model order by model.id asc";
        Query query = entityManager.createQuery(queryString);
        
        return query.getResultList();
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<CommentModel> findAllCommentsForIssueById(Long id) {
        StringBuffer queryString = new StringBuffer("select model from CommentModel model where "
                + "model.issue.id = :i order by model.id asc");
        Query query = entityManager.createQuery(queryString.toString());
        query.setParameter("i", id);
        
        return query.getResultList();
    }
    
    @Override
    public CommentModel findById(Long id) {
        try {
            CommentModel instance = entityManager.find(CommentModel.class, id);
            
            return instance;
        } catch (RuntimeException re) {
            throw re;
        }
    }
    
    @Override
    public CommentModel save(CommentModel entity) {
        entityManager.persist(entity);
        
        return entity;
    }
    
    @Override
    public CommentModel update(CommentModel entity) {
        entityManager.merge(entity);
        entityManager.flush();
        
        return entity;
    }
    
    @Override
    public void delete(CommentModel entity) {
        //entityManager.remove(entity);
        entityManager.remove(entityManager.find(CommentModel.class, entity.getId()));
    }
    
    public void deleteById(Long id) {
        entityManager.remove(entityManager.find(CommentModel.class, id));
    }
}
