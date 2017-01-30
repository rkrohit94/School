package com.allstate.controllers;


import com.allstate.entities.Klass;
import com.allstate.services.KlassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/klass")
public class KlassController {
    private KlassService service;

    @Autowired
    public void setService(KlassService service) {
        this.service = service;
    }
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Klass createKlass(@RequestBody Klass klass){
        return this.service.createKlass(klass);
    }
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public  Klass findById(@PathVariable int id){
        return this.service.findKlassById(id);
    }
}
