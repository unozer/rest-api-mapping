package it.gp.rest_api_mapping.service;

import it.gp.rest_api_mapping.mapper.PersonaMapper;
import it.gp.rest_api_mapping.model.Persona;
import it.gp.rest_api_mapping.model.PersonaDTO;
import it.gp.rest_api_mapping.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;
    private final PersonaMapper personaMapper = PersonaMapper.INSTANCE;

    public List<PersonaDTO> getAllPersone() {
        return personaRepository.findAll().stream()
                .map(personaMapper::entityToDTO)
                .collect(Collectors.toList());
    }

    public PersonaDTO getPersonaById(Long id) {
        return personaRepository.findById(id)
                .map(personaMapper::entityToDTO)
                .orElse(null);
    }

    public PersonaDTO savePersona(PersonaDTO personaDTO) {
        Persona persona = personaMapper.DTOToEntity(personaDTO);
        persona = personaRepository.save(persona);
        return personaMapper.entityToDTO(persona);
    }

    public void deletePersonaById(Long id) {
        personaRepository.deleteById(id);
    }
}
