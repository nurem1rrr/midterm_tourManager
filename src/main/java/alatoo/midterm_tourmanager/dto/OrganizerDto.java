package alatoo.midterm_tourmanager.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class OrganizerDto {

    private Long id;
    private String name;
    private String address;
    private String phone;

}
