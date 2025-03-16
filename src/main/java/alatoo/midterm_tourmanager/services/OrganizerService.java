package alatoo.midterm_tourmanager.services;

import alatoo.midterm_tourmanager.dto.OrganizerDto;
import alatoo.midterm_tourmanager.entities.Organizer;
import alatoo.midterm_tourmanager.mappers.OrganizerMapper;
import alatoo.midterm_tourmanager.repositories.OrganizerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrganizerService {

    private final OrganizerRepository organizerRepository;
    private final OrganizerMapper organizerMapper;

    public List<OrganizerDto> getAllOrganizers() {
        return organizerRepository.findAll()
                .stream()
                .map(organizerMapper::toDto)
                .collect(Collectors.toList());
    }

    public OrganizerDto getOrganizerById(Long id) {
        Organizer organizer = organizerRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Organizer not found"));
        return organizerMapper.toDto(organizer);
    }

    public OrganizerDto createOrganizer(OrganizerDto organizerDto) {
        Organizer organizer = organizerMapper
                .toEntity(organizerDto);
        Organizer savedOrganizer = organizerRepository.save(organizer);
        return organizerMapper.toDto(savedOrganizer);
    }

    public OrganizerDto deleteOrganizerById(Long id) {
        Organizer deletedOrganizer = organizerRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Organizer not found"));
        organizerRepository.delete(deletedOrganizer);
        return organizerMapper.toDto(deletedOrganizer);
    }
}
