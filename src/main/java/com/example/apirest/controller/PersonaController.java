package com.example.apirest.controller;

import com.example.apirest.entity.Persona;
import com.example.apirest.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    private PersonaService service;

    @GetMapping
    public List<Persona> findAll(){
        return service.findall();
    }

    @GetMapping("/{id}")
    public Persona geById(@PathVariable Long id){
        return service.findById(id).orElseThrow();
    }

    @PostMapping
    public Persona addEntity(@RequestBody Persona p) {
        return service.save(p);
    }

    @PutMapping("/{id}")
    public Persona updateById(@PathVariable Long id, @RequestBody Persona p){
        return service.update(id, p);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        service.deleteById(id);
    }

}
