package alatoo.midterm_tourmanager.repositoryTest;


import alatoo.midterm_tourmanager.entities.Location;
import alatoo.midterm_tourmanager.repositories.LocationRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class LocationRepositoryTest {

    @Autowired
    private LocationRepository locationRepository;

    @Test
    void testSaveAndFindById() {
        Location location = new Location();
        location.setCountry("Kyrgyzstan");
        locationRepository.save(location);

        Optional<Location> foundLocation = locationRepository.findById(location.getId());
        assertTrue(foundLocation.isPresent());
        assertEquals("Kyrgyzstan", foundLocation.get().getCountry());
    }

    @Test
    void testFindAll() {
        Location loc1 = new Location();
        loc1.setCountry("Kyrgyzstan");
        Location loc2 = new Location();
        loc2.setCountry("Uzbekistan");

        locationRepository.save(loc1);
        locationRepository.save(loc2);

        List<Location> locations = locationRepository.findAll();
        assertEquals(2, locations.size());
    }

    @Test
    void testDelete() {
        Location location = new Location();
        location.setCountry("Tajikistan");
        locationRepository.save(location);

        locationRepository.delete(location);

        Optional<Location> deletedLocation = locationRepository.findById(location.getId());
        assertFalse(deletedLocation.isPresent());
    }
}
