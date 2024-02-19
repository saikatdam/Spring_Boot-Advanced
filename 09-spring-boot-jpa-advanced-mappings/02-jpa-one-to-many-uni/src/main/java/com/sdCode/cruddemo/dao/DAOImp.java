package com.sdCode.cruddemo.dao;

import com.sdCode.cruddemo.entity.Instructor;
import com.sdCode.cruddemo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
public class DAOImp implements AppDAO{


private EntityManager entityManager;

//inject entity manager using constructor injection
   @Autowired
   public DAOImp(EntityManager entityManager){
       this.entityManager=entityManager;
   }
    @Override
    @Transactional
    public void save(Instructor theInstructor) {
    entityManager.persist(theInstructor);
    }
    @Override
   public Instructor findById(int id){
       return entityManager.find(Instructor.class,id);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int id) {
return entityManager.find(InstructorDetail.class,id);
    }
}
