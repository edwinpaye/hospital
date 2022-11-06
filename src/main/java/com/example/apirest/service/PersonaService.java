package com.example.apirest.service;

import com.example.apirest.entity.Persona;
import com.example.apirest.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository repo;

    public List<Persona> findall(){
        return repo.findAll();
    }

    public Optional<Persona> findById(Long id){
        return repo.findById(id);
    }

    public Persona save(Persona newPersona){
        return repo.save(newPersona);
    }

    public void deleteById(Long id){
        if(!repo.existsById(id))
            throw new EntityNotFoundException("Persona no encontrada");
        repo.deleteById(id);
    }

    public Persona update(Long id, Persona p){
        if(!repo.existsById(id))
            throw new EntityNotFoundException("Persona no encontrada");
        return repo.save(p);
    }
}
