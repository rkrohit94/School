package com.allstate.controllers;

import com.allstate.entities.Student;
import com.allstate.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/id/{id}" , method = RequestMethod.GET)
    public Student findStudentById(@PathVariable int id){
        return this.service.findStudentById(id);
    }

    @RequestMapping(value = "/email/{email}" , method = RequestMethod.GET)
    public Student findStudentByEmail(@PathVariable String email){
        return this.service.findStudentByEmail(email);
    }

}
