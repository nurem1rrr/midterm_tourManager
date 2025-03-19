package alatoo.midterm_tourmanager.repositoryTest;


import alatoo.midterm_tourmanager.entities.Organizer;
import alatoo.midterm_tourmanager.repositories.OrganizerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class OrganizerRepositoryTest {

    @Autowired
    private OrganizerRepository organizerRepository;

    @Test
    void testSaveAndFindById() {
        Organizer organizer = new Organizer();
        organizer.setName("Best Travel");
        organizerRepository.save(organizer);

        Optional<Organizer> foundOrganizer = organizerRepository.findById(organizer.getId());
        assertTrue(foundOrganizer.isPresent());
        assertEquals("Best Travel", foundOrganizer.get().getName());
    }

    @Test
    void testFindAll() {
        Organizer org1 = new Organizer();
        org1.setName("TourX");
        Organizer org2 = new Organizer();
        org2.setName("Mountain Guides");

        organizerRepository.save(org1);
        organizerRepository.save(org2);

        List<Organizer> organizers = organizerRepository.findAll();
        assertEquals(2, organizers.size());
    }

    @Test
    void testDelete() {
        Organizer organizer = new Organizer();
        organizer.setName("Sunrise Tours");
        organizerRepository.save(organizer);

        organizerRepository.delete(organizer);

        Optional<Organizer> deletedOrganizer = organizerRepository.findById(organizer.getId());
        assertFalse(deletedOrganizer.isPresent());
    }
}
