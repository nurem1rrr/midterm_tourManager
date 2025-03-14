package alatoo.midterm_tourmanager.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.Collection;


@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PACKAGE)
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
