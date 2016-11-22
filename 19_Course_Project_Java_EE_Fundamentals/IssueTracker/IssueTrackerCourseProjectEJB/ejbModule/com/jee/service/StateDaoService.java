package com.jee.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.jee.entity.StateModel;

@Stateless
public class StateDaoService implements StateDaoServiceLocal {
    
    @PersistenceContext
    protected EntityManager entityManager;
    
    public StateDaoService() {}
    
    @SuppressWarnings("unchecked")
    @Override
    public List<StateModel> findAllStates() {
        String queryString = "select model from StateModel model order by model.id asc";
        Query query = entityManager.createQuery(queryString);
        
        return query.getResultList();
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<StateModel> findAllStatesIssuesCount() {
        String queryString = "select new StateModel(statemodel.id, statemodel.state, COUNT (issuemodel)) "
                + "from StateModel statemodel left join statemodel.issues issuemodel group by statemodel.id "
                + "order by statemodel.id asc";
        Query query = entityManager.createQuery(queryString);
        
        return query.getResultList();
    }
    
    @Override
    public StateModel findById(Long id) {
        try {
            StateModel instance = entityManager.find(StateModel.class, id);
            
            return instance;
        } catch (RuntimeException re) {
            throw re;
        }
    }
    
    @Override
    public StateModel save(StateModel entity) {
        entityManager.persist(entity);
        
        return entity;
    }
    
    @Override
    public StateModel update(StateModel entity) {
        entityManager.merge(entity);
        entityManager.flush();
        
        return entity;
    }
    
    @Override
    public void delete(StateModel entity) {
        entityManager.remove(entity);
    }
}
