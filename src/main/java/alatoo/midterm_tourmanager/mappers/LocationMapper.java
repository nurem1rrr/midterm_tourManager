package alatoo.midterm_tourmanager.mappers;

import alatoo.midterm_tourmanager.dto.LocationDto;
import alatoo.midterm_tourmanager.entities.Location;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LocationMapper {
    LocationDto toDto(Location location);
    Location toEntity(LocationDto locationDto);
}
