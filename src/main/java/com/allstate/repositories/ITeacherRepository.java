package com.allstate.repositories;

import com.allstate.Enums.Gender;
import com.allstate.entities.Teacher;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by localadmin on 30/01/17.
 */
@Repository
public interface ITeacherRepository extends CrudRepository<Teacher, Integer> {


    List<Teacher> findByGender(Gender gender);
    List<Teacher> findByAgeGreaterThan(int age);
}
