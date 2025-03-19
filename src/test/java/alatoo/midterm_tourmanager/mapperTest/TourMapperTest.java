package alatoo.midterm_tourmanager.mapperTest;

import alatoo.midterm_tourmanager.dto.TourDto;
import alatoo.midterm_tourmanager.dto.CategoryDto;
import alatoo.midterm_tourmanager.dto.LocationDto;
import alatoo.midterm_tourmanager.dto.OrganizerDto;
import alatoo.midterm_tourmanager.entities.Tour;
import alatoo.midterm_tourmanager.entities.Category;
import alatoo.midterm_tourmanager.entities.Location;
import alatoo.midterm_tourmanager.entities.Organizer;
import alatoo.midterm_tourmanager.mappers.TourMapStructMapperImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class TourMapperTest {

    @InjectMocks
    private TourMapStructMapperImpl tourMapper;


    @Test
    void testToDto() {
        Category category = new Category(1L, "Adventure");
        Location location = new Location(1L, "Kyrgyzstan");
        Organizer organizer = new Organizer(1L, "Best Travel", "null", "null");

        Tour tour = new Tour();
        tour.setId(1L);
        tour.setTitle("Silk Road Tour");
        tour.setDescription("Explore ancient cities");
        tour.setPrice(500.0);
        tour.setCategoryOfTour(category);
        tour.setLocationOfTour(location);
        tour.setTourOrganizer(organizer);

        TourDto tourDto = tourMapper.toDto(tour);

        assertNotNull(tourDto);
        assertEquals(1L, tourDto.getId());
        assertEquals("Silk Road Tour", tourDto.getTitle());
        assertEquals("Explore ancient cities", tourDto.getDescription());
    }

    @Test
    void testToEntity() {
        CategoryDto categoryDto = new CategoryDto(2L, "Cultural");
        LocationDto locationDto = new LocationDto(2L, "Uzbekistan");
        OrganizerDto organizerDto = new OrganizerDto(2L, "Sunrise Tours", "null", "null");

        TourDto tourDto = new TourDto();
        tourDto.setId(2L);
        tourDto.setTitle("Mountain Adventure");
        tourDto.setDescription("Hiking in Alay");
        tourDto.setPrice(300.0);
        tourDto.setCategoryOfTour(categoryDto);
        tourDto.setLocationOfTour(locationDto);
        tourDto.setTourOrganizer(organizerDto);

        Tour tour = tourMapper.toEntity(tourDto);

        assertNotNull(tour);
        assertEquals(2L, tour.getId());
        assertEquals("Mountain Adventure", tour.getTitle());
        assertEquals("Hiking in Alay", tour.getDescription());
        assertEquals(300.0, tour.getPrice());
    }
}
