package alatoo.midterm_tourmanager.repositories;

import alatoo.midterm_tourmanager.entities.Tour;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TourRepository extends CrudRepository<Tour, Long> {
    List<Tour> findAll();

    List<Tour> findByCategoryOfTour_Type(String categoryType);
}
