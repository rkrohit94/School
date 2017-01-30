package com.allstate.repositories;

import com.allstate.entities.Klass;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface IKlassRepository extends CrudRepository<Klass, Integer> {

    Klass findByName(String name);

    String sql1 = "select * from klasses where teacher_id = ?1";
    @Query(value = sql1, nativeQuery = true)
    List<Klass> findAllKlassesOfTeacher(int teacherId);

}
