package com.jee.service;

import java.util.List;

import javax.ejb.Local;

import com.jee.entity.StateModel;

@Local
public interface StateDaoServiceLocal {
    
    List<StateModel> findAllStates();
    
    List<StateModel> findAllStatesIssuesCount();
    
    StateModel findById(Long id);
    
    StateModel save(StateModel entity);
    
    StateModel update(StateModel entity);
    
    void delete(StateModel entity);
}
