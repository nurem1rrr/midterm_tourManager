package alatoo.midterm_tourmanager.repository_test;

import alatoo.midterm_tourmanager.entities.Tour;
import alatoo.midterm_tourmanager.repositories.TourRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class TourRepositoryTest {

    @Autowired
    private TourRepository tourRepository;

    @Test
    void testSaveAndFindById() {
        Tour tour = new Tour();
        tour.setTitle("Silk Road Tour");
        tour.setDescription("Explore ancient cities");
        tour.setPrice(500.0);
        tourRepository.save(tour);

        Optional<Tour> foundTour = tourRepository.findById(tour.getId());
        assertTrue(foundTour.isPresent());
        assertEquals("Silk Road Tour", foundTour.get().getTitle());
    }

    @Test
    void testFindAll() {
        Tour tour1 = new Tour();
        tour1.setTitle("Alay Valley Trek");
        Tour tour2 = new Tour();
        tour2.setTitle("Issyk-Kul Beach Tour");

        tourRepository.save(tour1);
        tourRepository.save(tour2);

        List<Tour> tours = tourRepository.findAll();
        assertEquals(2, tours.size());
    }

    @Test
    void testDelete() {
        Tour tour = new Tour();
        tour.setTitle("Winter Ski Adventure");
        tourRepository.save(tour);

        tourRepository.delete(tour);

        Optional<Tour> deletedTour = tourRepository.findById(tour.getId());
        assertFalse(deletedTour.isPresent());
    }
}
