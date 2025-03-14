package alatoo.midterm_tourmanager.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Collection;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity

public class Organizer {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String address;
    private String phone;

}
