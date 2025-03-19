package alatoo.midterm_tourmanager.services;

import alatoo.midterm_tourmanager.dto.CategoryDto;
import alatoo.midterm_tourmanager.entities.Category;
import alatoo.midterm_tourmanager.mappers.CategoryMapper;
import alatoo.midterm_tourmanager.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class CategoryService implements CategoryServiceImpl {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public List<CategoryDto> getAllCategories() {
        return categoryRepository
                .findAll()
                .stream()
                .map(categoryMapper::toDto)
                .collect(Collectors.toList());
    }

    public CategoryDto getCategoryById(Long id) {
        Category category = categoryRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Not found"));
        return categoryMapper.toDto(category);
    }

    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = categoryMapper.toEntity(categoryDto);
        Category savedCategory = categoryRepository.save(category);
        return categoryMapper.toDto(savedCategory);
    }

    public CategoryDto updateCategory(Long id, CategoryDto categoryDto) {
        Category existingCategory = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category found"));

        existingCategory.setType(categoryDto.getType());

        Category updatedCategory = categoryRepository.save(existingCategory);
        return categoryMapper.toDto(updatedCategory);
    }

    public CategoryDto deleteCategory(Long id) {
        Category deletedCategory = categoryRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        categoryRepository.delete(deletedCategory);
        return categoryMapper.toDto(deletedCategory);
    }
}
