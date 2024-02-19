package com.sdCode.cruddemo.dao;

import com.sdCode.cruddemo.entity.Instructor;
import com.sdCode.cruddemo.entity.InstructorDetail;

public interface AppDAO {
    void save(Instructor theInstructor);
    Instructor findById(int id);

    InstructorDetail findInstructorDetailById(int id);
}

