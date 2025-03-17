package alatoo.midterm_tourmanager.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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

    @NotBlank(message = "Name can not be empty")
    @Size(min = 3, max = 100)
    private String name;

    @NotBlank(message = "Address can not be empty")
    @Size(min = 3, max = 100)
    private String address;
    private String phone;

}
