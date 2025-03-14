package alatoo.midterm_tourmanager.repositories;

import alatoo.midterm_tourmanager.entities.Organizer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrganizerRepository extends CrudRepository<Organizer, Long> {
    List<Organizer> findAll();
}
