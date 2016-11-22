package com.jee.web.beans.states;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.jee.entity.StateModel;
import com.jee.service.StateDaoServiceLocal;

@ManagedBean(name = "listStatesBean")
@ViewScoped
public class ListStatesBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @EJB
    StateDaoServiceLocal stateDaoService;
    
    @PostConstruct
    public void init() {}
    
    public List<StateModel> getAllStates() {
        return stateDaoService.findAllStates();
    }
    
    public List<StateModel> getAllStatesIssuesCount() {
        return stateDaoService.findAllStatesIssuesCount();
    }
}
