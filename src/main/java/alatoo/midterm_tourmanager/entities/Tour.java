package alatoo.midterm_tourmanager.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tours")
public class Tour {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String description;
    private Double price;

    @ManyToOne
    private Location locationOfTour;

    @ManyToOne
    private Organizer tourOrganizer;

    @ManyToOne
    private Category categoryOfTour;
}
