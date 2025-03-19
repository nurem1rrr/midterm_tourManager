package alatoo.midterm_tourmanager.mapperTest;

import alatoo.midterm_tourmanager.dto.CategoryDto;
import alatoo.midterm_tourmanager.entities.Category;
import alatoo.midterm_tourmanager.mappers.CategoryMapper;
import alatoo.midterm_tourmanager.mappers.CategoryMapperImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryMapperTest {

    private final CategoryMapper categoryMapper = new CategoryMapperImpl();

    @Test
    void testToDto() {
        Category category = new Category();
        category.setId(1L);
        category.setType("Adventure");

        CategoryDto categoryDto = categoryMapper.toDto(category);

        assertNotNull(categoryDto);
        assertEquals(1L, categoryDto.getId());
        assertEquals("Adventure", categoryDto.getType());
    }

    @Test
    void testToEntity() {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(1L);
        categoryDto.setType("Cultural");

        Category category = categoryMapper.toEntity(categoryDto);

        assertNotNull(category);
        assertEquals(1L, category.getId());
        assertEquals("Cultural", category.getType());
    }
}
