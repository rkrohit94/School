package com.allstate.services;

import com.allstate.entities.Student;
import com.allstate.repositories.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by localadmin on 30/01/17.
 */
@Service
public class StudentService {
    private IStudentRepository repository;

    @Autowired
    public void setRepository(IStudentRepository repository) {
        this.repository = repository;
    }

    public Student createStudent(Student student){
        return this.repository.save(student);
    }
    public Iterable<Student> findAllStudent(){
       return this.repository.findAll();
    }
    public Student findStudenById(int id){
        return this.repository.findOne(id);
    }
    public  Student findStudentByEmail(String email){
        return this.repository.findByEmail(email);
    }
}
