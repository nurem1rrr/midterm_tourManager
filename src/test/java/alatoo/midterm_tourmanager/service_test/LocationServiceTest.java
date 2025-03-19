package alatoo.midterm_tourmanager.service_test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import alatoo.midterm_tourmanager.dto.LocationDto;
import alatoo.midterm_tourmanager.entities.Location;
import alatoo.midterm_tourmanager.mappers.LocationMapper;
import alatoo.midterm_tourmanager.repositories.LocationRepository;
import alatoo.midterm_tourmanager.services.LocationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class LocationServiceTest {

    @Mock
    private LocationRepository locationRepository;

    @Mock
    private LocationMapper locationMapper;

    @InjectMocks
    private LocationService locationService;

    private Location location;
    private LocationDto locationDto;

    @BeforeEach
    void setUp() {
        location = new Location();
        location.setId(1L);
        location.setCountry("Kyrgyzstan");

        locationDto = new LocationDto();
        locationDto.setId(1L);
        locationDto.setCountry("Kyrgyzstan");
    }

    @Test
    void testGetAllLocations() {
        when(locationRepository.findAll()).thenReturn(List.of(location));
        when(locationMapper.toDto(any(Location.class))).thenReturn(locationDto);

        List<LocationDto> locations = locationService.getAllLocations();

        assertFalse(locations.isEmpty());
        assertEquals(1, locations.size());
        assertEquals("Kyrgyzstan", locations.get(0).getCountry());
    }

    @Test
    void testGetLocationById() {
        when(locationRepository.findById(1L)).thenReturn(Optional.of(location));
        when(locationMapper.toDto(any(Location.class))).thenReturn(locationDto);

        LocationDto foundLocation = locationService.getLocationById(1L);

        assertNotNull(foundLocation);
        assertEquals(1L, foundLocation.getId());
    }
}
