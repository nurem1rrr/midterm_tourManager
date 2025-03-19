package alatoo.midterm_tourmanager.services.servImpl;

import alatoo.midterm_tourmanager.dto.LocationDto;

import java.util.List;

public interface LocationServiceImpl {

    List<LocationDto> getAllLocations();

    LocationDto getLocationById(Long id);
}
