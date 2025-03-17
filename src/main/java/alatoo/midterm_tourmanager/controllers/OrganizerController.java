package alatoo.midterm_tourmanager.controllers;

import alatoo.midterm_tourmanager.dto.OrganizerDto;
import alatoo.midterm_tourmanager.services.OrganizerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Valid
@RestController
@RequestMapping("/organizer")
@RequiredArgsConstructor
public class OrganizerController {

    private final OrganizerService organizerService;

    @GetMapping
    public List<OrganizerDto> getAllOrganizers() {
        return organizerService
                .getAllOrganizers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrganizerDto> getOrganizerById(@PathVariable Long id) {
        return ResponseEntity
                .ok(organizerService.getOrganizerById(id));
    }

    @PostMapping
    public ResponseEntity<OrganizerDto> createOrganizer(@Valid @RequestBody OrganizerDto organizerDto) {
        OrganizerDto createdOrganizer = organizerService.createOrganizer(organizerDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdOrganizer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrganizerById(@PathVariable Long id) {
        organizerService.deleteOrganizerById(id);
        return ResponseEntity.ok("Organizer deleted successfully");
    }

}
