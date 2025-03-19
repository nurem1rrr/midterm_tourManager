package alatoo.midterm_tourmanager.serviceTest;


import alatoo.midterm_tourmanager.dto.TourDto;
import alatoo.midterm_tourmanager.entities.Tour;
import alatoo.midterm_tourmanager.mappers.TourMapStructMapper;
import alatoo.midterm_tourmanager.repositories.TourRepository;
import alatoo.midterm_tourmanager.services.TourService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TourServiceTest {

    @Mock
    private TourRepository tourRepository;
    @Mock
    private TourMapStructMapper tourMapper;

    @InjectMocks
    private TourService tourService;

    private Tour tour;
    private TourDto tourDto;

    @BeforeEach
    void setUp() {
        tour = new Tour(1L, "Mountain Tour", "Great experience", 200.0, null, null, null);
        tourDto = new TourDto(1L, "Mountain Tour", "Great experience", 200.0, null, null, null);
    }

    @Test
    void getAllTours_ShouldReturnListOfTours() {
        when(tourRepository.findAll()).thenReturn(List.of(tour));
        when(tourMapper.toDto(tour)).thenReturn(tourDto);

        List<TourDto> result = tourService.getAllTours();

        assertEquals(1, result.size());
        assertEquals("Mountain Tour", result.get(0).getTitle());
        verify(tourRepository, times(1)).findAll();
    }

    @Test
    void getTourById_ShouldReturnTour_WhenTourExists() {
        when(tourRepository.findById(1L)).thenReturn(Optional.of(tour));
        when(tourMapper.toDto(tour)).thenReturn(tourDto);

        TourDto result = tourService.getTourById(1L);

        assertNotNull(result);
        assertEquals("Mountain Tour", result.getTitle());
        verify(tourRepository, times(1)).findById(1L);
    }

    @Test
    void getTourById_ShouldThrowException_WhenTourNotFound() {
        when(tourRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> tourService.getTourById(1L));
        verify(tourRepository, times(1)).findById(1L);
    }

    @Test
    void createTour_ShouldReturnSavedTour() {
        when(tourMapper.toEntity(tourDto)).thenReturn(tour);
        when(tourRepository.save(tour)).thenReturn(tour);
        when(tourMapper.toDto(tour)).thenReturn(tourDto);

        TourDto result = tourService.createTour(tourDto);

        assertNotNull(result);
        assertEquals("Mountain Tour", result.getTitle());
        verify(tourRepository, times(1)).save(tour);
    }

    @Test
    void deleteTourById_ShouldDeleteTour_WhenExists() {
        when(tourRepository.findById(1L)).thenReturn(Optional.of(tour));

        tourService.deleteTourById(1L);

        verify(tourRepository, times(1)).deleteById(1L);
    }

    @Test
    void deleteTourById_ShouldThrowException_WhenNotFound() {
        when(tourRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> tourService.deleteTourById(1L));
        verify(tourRepository, times(1)).findById(1L);
    }
}
