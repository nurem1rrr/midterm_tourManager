package alatoo.midterm_tourmanager.controllers;

import alatoo.midterm_tourmanager.dto.LocationDto;
import alatoo.midterm_tourmanager.entities.Location;
import alatoo.midterm_tourmanager.services.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/location")
@RequiredArgsConstructor
public class LocationController {

    private final LocationService locationService;

    @GetMapping
    public List<LocationDto> getAllLocations() {
        return locationService
                .getAllLocations();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LocationDto> getLocationById(@PathVariable Long id) {
        return ResponseEntity
                .ok(locationService.getLocationById(id));
    }
}
