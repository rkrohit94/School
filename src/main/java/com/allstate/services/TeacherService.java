package com.allstate.services;

import com.allstate.Enums.Gender;
import com.allstate.entities.Klass;
import com.allstate.entities.Teacher;
import com.allstate.repositories.ITeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    private ITeacherRepository repository;

    @Autowired
    public void setRepository(ITeacherRepository repository) {
        this.repository = repository;
    }

    public Teacher createTeacher(Teacher teacher){
        return  this.repository.save(teacher);
    }
    public Teacher findById(int id){
        return this.repository.findOne(id);
    }
    public List<Teacher> findAllByGender(Gender gender){
        return this.repository.findByGender(gender);
    }

    public List<Teacher> findAllByAge(int age){
        return this.repository.findByAgeGreaterThan(age);
    }

    public Teacher findTeacherOfKlass(Klass klass){
        return this.repository.findOne(klass.getTeacher().getId());
    }

    public List<Klass> findKlassesOfTeacher(Teacher teacher){
        return teacher.getKlasses();
    }
}
