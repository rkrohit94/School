package com.allstate.services;

import com.allstate.Enums.Department;
import com.allstate.entities.Klass;
import com.allstate.entities.Student;
import com.allstate.entities.Teacher;
import com.allstate.repositories.IKlassRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.Table;
import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql("/sql/seed.sql")
public class KlassServiceTest {

    @Autowired
    private KlassService service;
    @Autowired
    private TeacherService teacherService;

    @Test
    public void shouldCreateClass() throws Exception {
        Teacher teacher = this.teacherService.findById(1);
        Klass klass = new Klass();
        klass.setName("compozed_accelerator");
        klass.setDepartment(Department.ENGINEERING);
        klass.setFee(2000.00);
        klass.setTeacher(teacher);
        Klass after = this.service.createKlass(klass);
        assertNotNull(after);
        assertEquals(4,after.getId());
    }

    @Test
    public void shouldFindKlassById() throws Exception {
        Klass result = this.service.findKlassById(1);
        assertNotNull(result);
        assertEquals("sumit sir class", result.getName());

    }
    @Test
    public  void shouldFindKlassByName() throws Exception{
        Klass result = this.service.findKlassByName("sumit sir class");
        assertNotNull(result);
        assertEquals(1,result.getId());
    }

}