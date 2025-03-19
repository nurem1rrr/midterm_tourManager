package alatoo.midterm_tourmanager.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;



@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity

public class Organizer {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String address;
    private String phone;
}
