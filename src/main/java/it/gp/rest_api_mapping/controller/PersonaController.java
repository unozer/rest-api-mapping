package it.gp.rest_api_mapping.controller;

import it.gp.rest_api_mapping.exception.PersonaNotFoundException;
import it.gp.rest_api_mapping.model.PersonaDTO;
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
    public List<PersonaDTO> getAllPersone() {
        return personaService.getAllPersone();
    }

    @GetMapping("/{id}")
    public PersonaDTO getPersonaById(@PathVariable Long id) {
        PersonaDTO p = personaService.getPersonaById(id);
        if (p == null)
            throw new PersonaNotFoundException("Persona not found with id:" + id);
        return p;
    }

    @PostMapping
    public PersonaDTO createPersona(@RequestBody PersonaDTO personaDTO) {
        return personaService.savePersona(personaDTO);
    }

    @DeleteMapping("/{id}")
    public void deletePersona(@PathVariable Long id) {
        if (personaService.getPersonaById(id) == null)
            throw new PersonaNotFoundException("Persona not found with id:" + id);
        personaService.deletePersonaById(id);
    }
}
