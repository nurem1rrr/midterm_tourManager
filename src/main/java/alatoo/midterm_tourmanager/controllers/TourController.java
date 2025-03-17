package alatoo.midterm_tourmanager.controllers;

import alatoo.midterm_tourmanager.dto.TourDto;
import alatoo.midterm_tourmanager.services.TourService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tours")
@RequiredArgsConstructor
public class TourController {

    private final TourService tourService;

    @GetMapping
    public List<TourDto> getAllTours() {
        return tourService
                .getAllTours();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TourDto> getTourById(@PathVariable Long id) {
        return ResponseEntity
                .ok(tourService.getTourById(id));
    }

    @PostMapping
    public ResponseEntity<TourDto> createTour(@RequestBody TourDto tourDto) {
        TourDto createdTour = tourService.createTour(tourDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("Location", "/tours/" + createdTour.getId())
                .body(createdTour);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TourDto> updateTour(@PathVariable Long id, @RequestBody TourDto tourDto) {
        return ResponseEntity.ok(tourService.updateTour(id, tourDto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TourDto> partiallyUpdateTour(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        return ResponseEntity.ok(tourService.partiallyUpdateTour(id, updates));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTourById(@PathVariable Long id) {
        tourService.deleteTourById(id);
        return ResponseEntity.ok("Tour deleted successfully");
    }

    @GetMapping("/by-category")
    public List<TourDto> getToursByCategory(@RequestParam String categoryType) {
        return tourService
                .getToursByCategory(categoryType);
    }

    @GetMapping("/by-organizer")
    public ResponseEntity<List<TourDto>> getToursByOrganizer(@RequestParam("organizerName") String organizerName) {
        List<TourDto> tours = tourService.getToursByOrganizer(organizerName);
        return ResponseEntity.ok(tours);
    }


    @GetMapping("/by-location")
    public List<TourDto> getToursByLocation(@RequestParam String locationName) {
        return tourService
                .getToursByLocation(locationName);
    }



}
