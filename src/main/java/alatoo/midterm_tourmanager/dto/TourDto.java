package alatoo.midterm_tourmanager.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class TourDto {

    private Long id;
    private String title;
    private String description;
    private Double price;
    private LocationDto locationOfTour;
    private CategoryDto categoryOfTour;
    private OrganizerDto tourOrganizer;

}
