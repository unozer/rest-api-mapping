package it.gp.rest_api_mapping.controller;

import it.gp.rest_api_mapping.exception.PersonaNotFoundException;
import it.gp.rest_api_mapping.model.Persona;
import it.gp.rest_api_mapping.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persone")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping
    public List<Persona> getAllPersone() {
        return personaService.getAllPersone();
    }

    @GetMapping("/{id}")
    public Persona getPersonaById(@PathVariable Long id) {
        Persona p = personaService.getPersonaById(id);
        if (p == null)
            throw new PersonaNotFoundException("Persona not found with id:" + id);
        return p;
    }

    @PostMapping
    public Persona createPersona(@RequestBody Persona persona) {
        return personaService.savePersona(persona);
    }

    @DeleteMapping("/{id}")
    public void deletePersona(@PathVariable Long id) {
        if (personaService.getPersonaById(id) == null)
            throw new PersonaNotFoundException("Persona not found with id:" + id);
        personaService.deletePersonaById(id);
    }
}
