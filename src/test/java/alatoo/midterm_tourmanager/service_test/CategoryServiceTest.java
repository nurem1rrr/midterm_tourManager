package alatoo.midterm_tourmanager.service_test;

import alatoo.midterm_tourmanager.dto.CategoryDto;
import alatoo.midterm_tourmanager.entities.Category;
import alatoo.midterm_tourmanager.mappers.CategoryMapper;
import alatoo.midterm_tourmanager.repositories.CategoryRepository;
import alatoo.midterm_tourmanager.services.CategoryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository;

    @Mock
    private CategoryMapper categoryMapper;

    @InjectMocks
    private CategoryService categoryService;

    @Test
    void getAllCategories_ShouldReturnList() {
        Category category = new Category();
        category.setId(1L);
        category.setType("Adventure");

        when(categoryRepository.findAll()).thenReturn(List.of(category));
        when(categoryMapper.toDto(any())).thenReturn(new CategoryDto(1L, "Adventure"));

        List<CategoryDto> categories = categoryService.getAllCategories();

        assertThat(categories).isNotEmpty();
        assertThat(categories.get(0).getType()).isEqualTo("Adventure");
    }

    @Test
    void getCategoryById_ShouldReturnCategoryDto() {
        Category category = new Category();
        category.setId(1L);
        category.setType("Adventure");

        when(categoryRepository.findById(1L)).thenReturn(Optional.of(category));
        when(categoryMapper.toDto(category)).thenReturn(new CategoryDto(1L, "Adventure"));

        CategoryDto categoryDto = categoryService.getCategoryById(1L);

        assertThat(categoryDto.getType()).isEqualTo("Adventure");
    }

    @Test
    void getCategoryById_ShouldThrowException_WhenNotFound() {
        when(categoryRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> categoryService.getCategoryById(1L));
    }

    @Test
    void createCategory_ShouldReturnSavedCategoryDto() {
        CategoryDto categoryDto = new CategoryDto(null, "Adventure");
        Category category = new Category();
        category.setType("Adventure");

        when(categoryMapper.toEntity(categoryDto)).thenReturn(category);
        when(categoryRepository.save(category)).thenReturn(category);
        when(categoryMapper.toDto(category)).thenReturn(new CategoryDto(1L, "Adventure"));

        CategoryDto savedCategory = categoryService.createCategory(categoryDto);

        assertThat(savedCategory.getType()).isEqualTo("Adventure");
    }

    @Test
    void updateCategory_ShouldUpdateAndReturnCategoryDto() {
        Category existingCategory = new Category();
        existingCategory.setId(1L);
        existingCategory.setType("Old Type");

        CategoryDto updateDto = new CategoryDto(null, "New Type");

        when(categoryRepository.findById(1L)).thenReturn(Optional.of(existingCategory));
        when(categoryRepository.save(any())).thenReturn(existingCategory);
        when(categoryMapper.toDto(existingCategory)).thenReturn(new CategoryDto(1L, "New Type"));

        CategoryDto updatedCategory = categoryService.updateCategory(1L, updateDto);

        assertThat(updatedCategory.getType()).isEqualTo("New Type");
    }

    @Test
    void deleteCategory_ShouldDeleteAndReturnCategoryDto() {
        Category category = new Category();
        category.setId(1L);
        category.setType("Adventure");

        when(categoryRepository.findById(1L)).thenReturn(Optional.of(category));
        when(categoryMapper.toDto(category)).thenReturn(new CategoryDto(1L, "Adventure"));
        doNothing().when(categoryRepository).delete(category);

        CategoryDto deletedCategory = categoryService.deleteCategory(1L);

        assertThat(deletedCategory.getType()).isEqualTo("Adventure");
        verify(categoryRepository, times(1)).delete(category);
    }
}
