package com.allstate.controllers;

import com.allstate.entities.Student;
import com.allstate.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by localadmin on 30/01/17.
 */
@RestController
@RequestMapping(value = "/student")
public class StudentController {
    private StudentService service;

    @Autowired
    public void setService(StudentService service) {
        this.service = service;
    }

    @RequestMapping(value = "" , method = RequestMethod.POST)
    public Student createStudent(@RequestBody Student student){
        return this.service.createStudent(student);
    }

    @RequestMapping(value = "" , method = RequestMethod.GET)
    public Iterable<Student> findAllStudent(){
        return this.service.findAllStudent();
    }

}
