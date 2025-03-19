package alatoo.midterm_tourmanager.services;

import alatoo.midterm_tourmanager.dto.TourDto;

import java.util.List;
import java.util.Map;

public interface TourServiceImpl {

    List<TourDto> getAllTours();

    TourDto getTourById(Long id);

    TourDto createTour(TourDto tourDto);

    TourDto updateTour(Long id, TourDto tourDto);

    void deleteTourById(Long id);

    List<TourDto> getToursByLocation(String locationName);

    List<TourDto> getToursByOrganizer(String OrganizerName);

    List<TourDto> getToursByCategory(String categoryName);

    TourDto partiallyUpdateTour(Long id, Map<String, Object> updates);

}
