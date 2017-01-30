package com.allstate.services;



import com.allstate.entities.Klass;
import com.allstate.entities.Teacher;
import com.allstate.repositories.IKlassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KlassService {

    private IKlassRepository repository;

    @Autowired
    public void setRepository(IKlassRepository repository) {
        this.repository = repository;
    }

    public Klass createKlass(Klass klass){
        return this.repository.save(klass);
    }
    public Iterable<Klass> findAllKlass(){
        return this.repository.findAll();
    }

    public Klass findKlassById(int id){
        return this.repository.findOne(id);
    }
    public  Klass findKlassByName(String name){
        return this.repository.findByName(name);
    }
    public List<Klass> findKlassOfTeacher(int teacherId){
        return this.repository.findAllKlassesOfTeacher(teacherId);
    }
}
