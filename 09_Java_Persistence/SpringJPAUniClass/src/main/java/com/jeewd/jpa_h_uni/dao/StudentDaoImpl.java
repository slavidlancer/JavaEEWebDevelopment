package com.jeewd.jpa_h_uni.dao;

import java.util.List;
//import org.hibernate.Criteria;
/*import org.hibernate.Session;
import org.hibernate.Transaction;*/
//import org.hibernate.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
//import org.hibernate.SessionFactory;
//import org.hibernate.criterion.Restrictions;
//import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.TypedQuery;
/*import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;*/
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.jeewd.jpa_h_uni.entities.Student;

@Repository
public class StudentDaoImpl implements StudentDao {
    @PersistenceContext
    private EntityManager entityManager;
    
    /*@Autowired
    private SessionFactory sessionFactory;*/
    
    @Override
    public List<Student> getStudents() {
        // JPQL
        String jpql = "select s from Student s";
        TypedQuery<Student> query = entityManager.createQuery(jpql,
                Student.class);
        
        return query.getResultList();
        
        // JPA Criteria
        /*CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> criteriaQuery =
        criteriaBuilder.createQuery(Student.class);
        Root<Student> from = criteriaQuery.from(Student.class);
        
        criteriaQuery.where(from.get("name").in("New Name", "User Name"));
        
        criteriaQuery.select(from);
        TypedQuery<Student> query = entityManager.createQuery(criteriaQuery);
        
        return query.getResultList();*/
        
        // HQL
        /*String hql = "FROM com.jeewd.jpa_h_uni.entities.Student";
        Query query = sessionFactory.openSession().createQuery(hql);
        
        return query.list();*/
        
        // Hibernate Criteria
        /*Criteria criteria = sessionFactory.openSession().createCriteria(
                Student.class);
        criteria.add(Restrictions.like("name", "User%"));

        return criteria.list();*/
    }

    @Override
    @Transactional
    public boolean addStudent(Student student) {
        student.setId(5L);
        
        //JPA
        entityManager.persist(student);
        
        //Hibernate
        /*Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        
        session.save(student);
        transaction.commit();
        session.close();*/
        
        return true;
    }
}
