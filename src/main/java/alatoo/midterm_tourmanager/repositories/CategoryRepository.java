package alatoo.midterm_tourmanager.repositories;

import alatoo.midterm_tourmanager.entities.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    List<Category> findAll();
}
