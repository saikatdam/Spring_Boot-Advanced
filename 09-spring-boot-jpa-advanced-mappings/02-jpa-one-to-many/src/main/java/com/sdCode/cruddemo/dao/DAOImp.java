package com.sdCode.cruddemo.dao;

import com.sdCode.cruddemo.entity.Course;
import com.sdCode.cruddemo.entity.Instructor;
import com.sdCode.cruddemo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Join;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

//    @Override
//    public Instructor findInstructorById(int id){
//       TypedQuery instructor =entityManager.createQuery("from Instructor where Instructor.id=:id",Instructor.class);
//      instructor.setParameter("id",id);
//       Instructor instructorResult= (Instructor) instructor.getResultList();
//       return instructorResult;
//    }

    @Override
    public List<Course> findCoursesByInstructorId(int theId) {
        TypedQuery<Course> query=entityManager.createQuery("from Course where instructor.id=:theId",Course.class);
        query.setParameter("theId",theId);
        List<Course> courses= query.getResultList();
        return courses;
    }
    @Override
    public Instructor findInstructorByIdJoinFetch(int idd){
       TypedQuery<Instructor> ins=entityManager.createQuery(
                                             "select i from Instructor i "
                                             + "JOIN FETCH i.courses " + "JOIN FETCH i.instructorDetail "
                                              + "where i.id = :data",Instructor.class);
      ins.setParameter("data",idd);
      Instructor instructor=ins.getSingleResult();
       return instructor;
    }

    @Override
    @Transactional
    public void saveData(Course course){
       entityManager.persist(course);
    }

}
