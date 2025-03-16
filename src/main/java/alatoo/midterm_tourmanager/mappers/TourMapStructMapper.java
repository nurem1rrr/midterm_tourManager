package alatoo.midterm_tourmanager.mappers;

import alatoo.midterm_tourmanager.dto.TourDto;
import alatoo.midterm_tourmanager.entities.Tour;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {LocationMapper.class, CategoryMapper.class, OrganizerMapper.class})
public interface TourMapStructMapper {
    @Mapping(source = "locationOfTour", target = "location")
    @Mapping(source = "categoryOfTour", target = "category")
    @Mapping(source = "tourOrganizer", target = "organizer")
    TourDto toDto(Tour tour);

    @Mapping(source = "location", target = "locationOfTour")
    @Mapping(source = "category", target = "categoryOfTour")
    @Mapping(source = "organizer", target = "tourOrganizer")
    Tour toEntity(TourDto tourDto);
}
