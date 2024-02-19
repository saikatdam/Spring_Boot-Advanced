package com.sdCode.cruddemo.dao;

import com.sdCode.cruddemo.entity.Course;
import com.sdCode.cruddemo.entity.Instructor;
import com.sdCode.cruddemo.entity.InstructorDetail;

import java.util.List;

public interface AppDAO {
    void save(Instructor theInstructor);
    Instructor findById(int id);

    InstructorDetail findInstructorDetailById(int id);
//    Instructor findInstructorById(int id);
    List<Course> findCoursesByInstructorId(int theId);
    Instructor findInstructorByIdJoinFetch(int id);
    void saveData(Course course);
}

