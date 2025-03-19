package alatoo.midterm_tourmanager.repository_test;

import alatoo.midterm_tourmanager.entities.Category;
import alatoo.midterm_tourmanager.repositories.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    void testSaveAndFindById() {
        Category category = new Category();
        category.setType("Adventure");
        categoryRepository.save(category);

        Optional<Category> foundCategory = categoryRepository.findById(category.getId());
        assertTrue(foundCategory.isPresent());
        assertEquals("Adventure", foundCategory.get().getType());
    }

    @Test
    void testFindAll() {
        Category category1 = new Category();
        category1.setType("Adventure");
        Category category2 = new Category();
        category2.setType("Cultural");

        categoryRepository.save(category1);
        categoryRepository.save(category2);

        List<Category> categories = categoryRepository.findAll();
        assertEquals(2, categories.size());
    }

    @Test
    void testDelete() {
        Category category = new Category();
        category.setType("Hiking");
        categoryRepository.save(category);

        categoryRepository.delete(category);

        Optional<Category> deletedCategory = categoryRepository.findById(category.getId());
        assertFalse(deletedCategory.isPresent());
    }
}
