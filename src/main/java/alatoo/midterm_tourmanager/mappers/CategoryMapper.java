package alatoo.midterm_tourmanager.mappers;

import alatoo.midterm_tourmanager.dto.CategoryDto;
import alatoo.midterm_tourmanager.entities.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryDto toDto(Category category);
    Category toEntity(CategoryDto categoryDto);
}