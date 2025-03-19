package alatoo.midterm_tourmanager.services;

import alatoo.midterm_tourmanager.dto.OrganizerDto;

import java.util.List;

public interface OrganizerServiceImpl {

    List<OrganizerDto> getAllOrganizers();

    OrganizerDto getOrganizerById(Long id);

    OrganizerDto createOrganizer(OrganizerDto organizerDto);

    void deleteOrganizerById(Long id);
}
