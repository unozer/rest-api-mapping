package it.gp.rest_api_mapping.mapper;

import it.gp.rest_api_mapping.model.Persona;
import it.gp.rest_api_mapping.model.PersonaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonaMapper {

    PersonaMapper INSTANCE = Mappers.getMapper(PersonaMapper.class);

    @Mapping(target = "email", ignore = true)
    PersonaDTO entityToDTO(Persona persona);

    Persona DTOToEntity(PersonaDTO personaDTO);
}
