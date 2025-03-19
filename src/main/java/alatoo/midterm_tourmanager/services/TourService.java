package alatoo.midterm_tourmanager.services;

import alatoo.midterm_tourmanager.dto.TourDto;
import alatoo.midterm_tourmanager.entities.Tour;
import alatoo.midterm_tourmanager.mappers.CategoryMapper;
import alatoo.midterm_tourmanager.mappers.LocationMapper;
import alatoo.midterm_tourmanager.mappers.OrganizerMapper;
import alatoo.midterm_tourmanager.mappers.TourMapStructMapper;
import alatoo.midterm_tourmanager.repositories.TourRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TourService implements TourServiceImpl{

    private final TourRepository tourRepository;
    private final TourMapStructMapper tourMapper;
    private final LocationMapper locationMapper;
    private final CategoryMapper categoryMapper;
    private final OrganizerMapper organizerMapper;

    public List<TourDto> getAllTours() {
        List<Tour> tours = tourRepository.findAll();
        return tours.stream()
                .map(tourMapper::toDto)
                .collect(Collectors.toList());
    }

    public TourDto getTourById(Long id) {
        Tour tour = tourRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tour not found"));
        return tourMapper.toDto(tour);
    }

    public TourDto createTour(TourDto tourDto) {
        Tour tour = tourMapper.toEntity(tourDto);
        Tour savedTour = tourRepository.save(tour);
        return tourMapper.toDto(savedTour);
    }

    public TourDto updateTour(Long id, TourDto tourDto) {
        Tour existingTour = tourRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tour not found"));

        existingTour.setTitle(tourDto.getTitle());
        existingTour.setDescription(tourDto.getDescription());
        existingTour.setPrice(tourDto.getPrice());
        existingTour.setLocationOfTour(locationMapper.toEntity(tourDto.getLocationOfTour()));
        existingTour.setCategoryOfTour(categoryMapper.toEntity(tourDto.getCategoryOfTour()));
        existingTour.setTourOrganizer(organizerMapper.toEntity(tourDto.getTourOrganizer()));

        Tour updatedTour = tourRepository.save(existingTour);
        return tourMapper.toDto(updatedTour);
    }

    public void deleteTourById(Long id) {
        Tour deletedTour = tourRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Tour not found"));
        tourRepository.deleteById(id);
        tourMapper.toDto(deletedTour);
    }

    public List<TourDto> getToursByCategory(String categoryType) {
        List<Tour> tours = tourRepository.findByCategoryOfTour_Type(categoryType);
        return tours.stream()
                .map(tourMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<TourDto> getToursByOrganizer(String organizerName) {
        List<Tour> tours = tourRepository.findByTourOrganizer_Name(organizerName);
        return tours
                .stream()
                .map(tourMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<TourDto> getToursByLocation(String locationName) {
        List<Tour> tours = tourRepository.findByLocationOfTour_Country(locationName);
        return tours
                .stream()
                .map(tourMapper::toDto)
                .collect(Collectors.toList());
    }

    public TourDto partiallyUpdateTour(Long id, Map<String, Object> updates) {
        Tour tour = tourRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tour not found"));

        updates.forEach((key, value) -> {
            switch (key) {
                case "title" -> tour.setTitle((String) value);
                case "description" -> tour.setDescription((String) value);
                case "price" -> tour.setPrice(Double.valueOf(value.toString()));
            }
        });
        Tour updatedTour = tourRepository.save(tour);
        return tourMapper.toDto(updatedTour);
    }
}
