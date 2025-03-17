package alatoo.midterm_tourmanager.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class TourDto {

    private Long id;

    @NotBlank(message = "Title of tour can not be empty")
    @Size(min = 3, max = 100)
    private String title;

    private String description;

    @NotNull(message = "Price can not be empty")
    @Min(value = 1)
    private Double price;
    private LocationDto locationOfTour;
    private CategoryDto categoryOfTour;
    private OrganizerDto tourOrganizer;

}
