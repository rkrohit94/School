package com.allstate.repositories;

import com.allstate.entities.Student;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by localadmin on 30/01/17.
 */
public interface IStudentRepository extends CrudRepository<Student, Integer> {
    public Student findByEmail(String email);
}
