package com.jee.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.jee.entity.IssueModel;

@Stateless
public class IssueDaoService implements IssueDaoServiceLocal {
    
    @PersistenceContext
    protected EntityManager entityManager;
    
    public IssueDaoService() {}
    
    @SuppressWarnings("unchecked")
    @Override
    public List<IssueModel> findAllIssues() {
        String queryString = "select model from IssueModel model order by model.state.id asc";
        Query query = entityManager.createQuery(queryString);
        
        return query.getResultList();
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<IssueModel> findAllIssuesCommentsCount() {
        String queryString = "select new IssueModel(issuemodel.id, issuemodel.title, issuemodel.description, "
                + "issuemodel.author, issuemodel.state, issuemodel.submissionDateTime, COUNT(commentmodel)) "
                + "from IssueModel issuemodel left join issuemodel.comments commentmodel group by issuemodel.id "
                + "order by issuemodel.state.id asc";
        Query query = entityManager.createQuery(queryString);
        
        return query.getResultList();
    }
    
    @Override
    public Long findAllIssuesCount() {
        String queryString = "select COUNT(*) from IssueModel";
        Query query = entityManager.createQuery(queryString);
        
        return (long) query.getResultList().get(0);
    }
    
    @Override
    public Long findIssueCommentsCountById(Long id) {
        String queryString = "select COUNT(*) from CommentModel model where model.issue.id = :i";
        Query query = entityManager.createQuery(queryString);
        query.setParameter("i", id);
        
        return (long) query.getResultList().get(0);
    }
    
    @Override
    public IssueModel findById(Long id) {
        try {
            IssueModel instance = entityManager.find(IssueModel.class, id);
            
            return instance;
        } catch (RuntimeException re) {
            throw re;
        }
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<IssueModel> findByState(String state) {
        StringBuffer queryString = new StringBuffer("select model from IssueModel model");
        boolean includeState = false;
        
        if ((state != null) && !("".equals(state))) {
            queryString.append(" where model.state.state = :s");
            includeState = true;
        }
        
        queryString.append(" order by model.state.id asc");
        Query query = entityManager.createQuery(queryString.toString());
        
        if (includeState) {
            query.setParameter("s", state);
        }
        
        return query.getResultList();
    }
    
    @Override
    public IssueModel save(IssueModel entity) {
        entityManager.persist(entity);
        
        return entity;
    }
    
    @Override
    public IssueModel update(IssueModel entity) {
        entityManager.merge(entity);
        entityManager.flush();
        
        return entity;
    }
    
    @Override
    public void delete(IssueModel entity) {
        entityManager.remove(entityManager.find(IssueModel.class, entity.getId()));
    }
    
    @Override
    public void deleteById(Long id) {
        entityManager.remove(entityManager.find(IssueModel.class, id));
    }
}
