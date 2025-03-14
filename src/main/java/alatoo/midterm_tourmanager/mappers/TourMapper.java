package alatoo.midterm_tourmanager.mappers;

import alatoo.midterm_tourmanager.dto.CategoryDto;
import alatoo.midterm_tourmanager.dto.LocationDto;
import alatoo.midterm_tourmanager.dto.OrganizerDto;
import alatoo.midterm_tourmanager.dto.TourDto;
import alatoo.midterm_tourmanager.entities.Category;
import alatoo.midterm_tourmanager.entities.Location;
import alatoo.midterm_tourmanager.entities.Organizer;
import alatoo.midterm_tourmanager.entities.Tour;
import org.springframework.stereotype.Component;

@Component
public class TourMapper {
    public TourDto toDto(Tour tour) {
        return TourDto.builder()
                .id(tour.getId())
                .title(tour.getTitle())
                .description(tour.getDescription())
                .price(tour.getPrice())
                .locationOfTour(toLocationDto(tour.getLocationOfTour()))
                .tourOrganizer(toOrganizerDto(tour.getTourOrganizer()))
                .categoryOfTour(toCategoryDto(tour.getCategoryOfTour()))
                .build();
    }

    public Tour toEntity(TourDto dto, Location location, Organizer organizer, Category category) {
        return Tour.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .description(dto.getDescription())
                .price(dto.getPrice())
                .locationOfTour(location)
                .tourOrganizer(organizer)
                .categoryOfTour(category)
                .build();
    }

    private LocationDto toLocationDto(Location location) {
        return new LocationDto(location.getId(), location.getCountry());
    }

    private CategoryDto toCategoryDto(Category category) {
        return new CategoryDto(category.getId(), category.getType());
    }

    private OrganizerDto toOrganizerDto(Organizer organizer) {
        return new OrganizerDto(organizer.getId(), organizer.getName(), organizer.getAddress(), organizer.getPhone())
    }
}
