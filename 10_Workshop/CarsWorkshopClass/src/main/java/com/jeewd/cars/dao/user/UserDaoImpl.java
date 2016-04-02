package com.jeewd.cars.dao.user;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Repository;
import com.jeewd.cars.entities.user.AutoUser;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public AutoUser getUser(String username) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<AutoUser> criteriaQuery = criteriaBuilder.createQuery(
                AutoUser.class);
        Root<AutoUser> from = criteriaQuery.from(AutoUser.class);
        
        criteriaQuery.where(from.get("username").in(username));
        criteriaQuery.select(from);
        
        TypedQuery<AutoUser> query = entityManager.createQuery(criteriaQuery);
        List<AutoUser> users = query.getResultList();
        
        return users != null ? users.get(0) : null;
    }

    @Override
    public List<AutoUser> getUsers(String username, String status) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<AutoUser> criteriaQuery = criteriaBuilder.createQuery(
                AutoUser.class);
        Root<AutoUser> from = criteriaQuery.from(AutoUser.class);
        Predicate predicate1 = criteriaBuilder.and();
        Predicate predicate2 = criteriaBuilder.and();
        
        if (status != null && !status.isEmpty()) {
            predicate1 = from.get("status").in(status);
        }
        
        if (username != null && !username.isEmpty()) {
            predicate2 = from.get("username").in(username);
        }
        
        criteriaQuery.where(predicate1, predicate2);
        criteriaQuery.select(from);
        
        TypedQuery<AutoUser> query = entityManager.createQuery(criteriaQuery);
        
        return query.getResultList();
    }
}
