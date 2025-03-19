package alatoo.midterm_tourmanager.services;

import alatoo.midterm_tourmanager.dto.LocationDto;
import alatoo.midterm_tourmanager.entities.Location;
import alatoo.midterm_tourmanager.mappers.LocationMapper;
import alatoo.midterm_tourmanager.repositories.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LocationService implements LocationServiceImpl{

    private final LocationRepository locationRepository;
    private final LocationMapper locationMapper;

    public List<LocationDto> getAllLocations() {
        return locationRepository
                .findAll()
                .stream()
                .map(locationMapper::toDto)
                .collect(Collectors.toList())                ;
    }

    public LocationDto getLocationById(Long id) {
        Location location = locationRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Not found"));
        return locationMapper.toDto(location);
    }
}
