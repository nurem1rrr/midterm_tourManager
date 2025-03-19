package alatoo.midterm_tourmanager.mapper_test;

import alatoo.midterm_tourmanager.dto.LocationDto;
import alatoo.midterm_tourmanager.entities.Location;
import alatoo.midterm_tourmanager.mappers.LocationMapper;
import alatoo.midterm_tourmanager.mappers.LocationMapperImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocationMapperTest {

    private final LocationMapper locationMapper = new LocationMapperImpl();

    @Test
    void testToDto() {
        Location location = new Location();
        location.setId(1L);
        location.setCountry("Kyrgyzstan");

        LocationDto locationDto = locationMapper.toDto(location);

        assertNotNull(locationDto);
        assertEquals(1L, locationDto.getId());
        assertEquals("Kyrgyzstan", locationDto.getCountry());
    }

    @Test
    void testToEntity() {
        LocationDto locationDto = new LocationDto();
        locationDto.setId(1L);
        locationDto.setCountry("Uzbekistan");

        Location location = locationMapper.toEntity(locationDto);

        assertNotNull(location);
        assertEquals(1L, location.getId());
        assertEquals("Uzbekistan", location.getCountry());
    }
}
