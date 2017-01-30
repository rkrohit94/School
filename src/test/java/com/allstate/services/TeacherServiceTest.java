package com.allstate.services;

import com.allstate.Enums.Gender;
import com.allstate.entities.Klass;
import com.allstate.entities.Teacher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql("/sql/seed.sql")
public class TeacherServiceTest {

    @Autowired
    private TeacherService service;

    @Autowired
    private KlassService klassService;

    @Test
    public void createTeacher() throws Exception {
        Teacher teacher = new Teacher();
        teacher.setName("sumit sir");
        teacher.setAge(75);
        teacher.setGender(Gender.MALE);
        Teacher after = this.service.createTeacher(teacher);
        assertNotNull(after);
        assertEquals(3,after.getId());
    }

    @Test
    public void findById() throws Exception {
        Teacher teacher = this.service.findById(1);
        assertNotNull(teacher);
        assertEquals("chyld", teacher.getName());
    }

    @Test
    public void findAllByGender() throws Exception{
        List<Teacher> teachers = this.service.findAllByGender(Gender.MALE);
        assertNotNull(teachers);
        assertEquals(2,teachers.size());
    }

    @Test
    public void findAllByCertainAge() throws Exception{
        List<Teacher> teachers = this.service.findAllByAge(30);
        assertNotNull(teachers);
        assertEquals(1,teachers.size());
    }

    @Test
    public void shouldFindTeacherForAGivenClass() throws Exception{

        Klass klass = this.klassService.findKlassById(1);
        Teacher teacher = this.service.findTeacherOfKlass(klass);

        assertNotNull(teacher);
        assertEquals("chyld", teacher.getName());
    }

    @Test
    @Transactional
    public void shouldReturnClassOfTeacher() throws Exception{
        Teacher teacher  = this.service.findById(1);
        List<Klass> klasses= this.service.findKlassesOfTeacher(teacher);
        assertNotNull(klasses);
        assertEquals(2,klasses.size());
    }
}