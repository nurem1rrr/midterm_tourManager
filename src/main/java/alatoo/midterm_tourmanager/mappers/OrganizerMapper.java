package alatoo.midterm_tourmanager.mappers;

import alatoo.midterm_tourmanager.dto.OrganizerDto;
import alatoo.midterm_tourmanager.entities.Organizer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrganizerMapper {
    OrganizerDto toDto(Organizer organizer);
    Organizer toEntity(OrganizerDto organizerDto);
}
