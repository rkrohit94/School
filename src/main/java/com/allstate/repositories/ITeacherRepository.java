package com.allstate.repositories;

import com.allstate.Enums.Gender;
import com.allstate.entities.Teacher;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by localadmin on 30/01/17.
 */
public interface ITeacherRepository extends CrudRepository<Teacher, Integer> {

    String sql1 = "select * from teachers where sex = ?1";
    @Query(value = sql1, nativeQuery = true)
    List<Teacher> findByGender(@Param("sex") String gender);

    String sql2 = "select * from teachers where age > ?1";
    @Query(value = sql2, nativeQuery = true)
    List<Teacher> findByAge(@Param("age") int age);
}
