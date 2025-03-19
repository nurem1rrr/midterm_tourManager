package alatoo.midterm_tourmanager.mappers;

import alatoo.midterm_tourmanager.dto.TourDto;
import alatoo.midterm_tourmanager.entities.Tour;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {LocationMapper.class, CategoryMapper.class, OrganizerMapper.class})
public interface TourMapStructMapper {
    TourDto toDto(Tour tour);

    Tour toEntity(TourDto tourDto);
}
