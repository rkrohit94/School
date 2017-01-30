package com.allstate.services;

import com.allstate.entities.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql("/sql/seed.sql")
public class StudentServiceTest {
    private StudentService service;

    @Autowired
    public void setService(StudentService service) {
        this.service = service;
    }

    @Test
    public void createStudent() throws Exception {
        Student student = new Student();
        student.setEmail("xyz@gmail.com");
        Student returnValue = this.service.createStudent(student);
        assertEquals(5, returnValue.getId());
    }

    @Test
    public void shouldFindStudentById() throws Exception{
        Student student = this.service.findStudenById(1);
        assertNotNull(student);
        assertEquals("aaa@aol.com",student.getEmail());
    }

    @Test
    public void shouldFindStudentByEmail() throws Exception{
        Student student = this.service.findStudentByEmail("aaa@aol.com");
        assertNotNull(student);
        assertEquals(1,student.getId());
    }

}