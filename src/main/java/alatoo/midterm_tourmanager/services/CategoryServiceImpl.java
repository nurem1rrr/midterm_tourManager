package alatoo.midterm_tourmanager.services;

import alatoo.midterm_tourmanager.dto.CategoryDto;

import java.util.List;

public interface CategoryServiceImpl {

    List<CategoryDto> getAllCategories();

    CategoryDto getCategoryById(Long id);

    CategoryDto createCategory(CategoryDto categoryDto);

    CategoryDto updateCategory(Long id, CategoryDto categoryDto);

    CategoryDto deleteCategory(Long id);

}
