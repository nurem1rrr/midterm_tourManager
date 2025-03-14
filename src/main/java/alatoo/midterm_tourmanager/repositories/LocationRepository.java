package alatoo.midterm_tourmanager.repositories;

import alatoo.midterm_tourmanager.entities.Location;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LocationRepository extends CrudRepository<Location, Long> {
    List<Location> findAll();
}
