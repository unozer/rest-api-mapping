package it.gp.rest_api_mapping.service;

import it.gp.rest_api_mapping.model.Persona;
import it.gp.rest_api_mapping.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    public List<Persona> getAllPersone() {
        return personaRepository.findAll();
    }

    public Persona getPersonaById(Long id) {
        System.out.println("ID="+id);
        return personaRepository.findById(id).orElse(null);
    }

    public Persona savePersona(Persona persona) {
        return personaRepository.save(persona);
    }

    public void deletePersonaById(Long id) {
        personaRepository.deleteById(id);
    }
}
