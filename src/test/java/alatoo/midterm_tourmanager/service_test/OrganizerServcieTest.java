package alatoo.midterm_tourmanager.service_test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import alatoo.midterm_tourmanager.dto.OrganizerDto;
import alatoo.midterm_tourmanager.entities.Organizer;
import alatoo.midterm_tourmanager.mappers.OrganizerMapper;
import alatoo.midterm_tourmanager.repositories.OrganizerRepository;
import alatoo.midterm_tourmanager.services.OrganizerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ExtendWith(MockitoExtension.class)
class OrganizerServiceTest {

    @Mock
    private OrganizerRepository organizerRepository;

    @Mock
    private OrganizerMapper organizerMapper;

    @InjectMocks
    private OrganizerService organizerService;

    private Organizer organizer;
    private OrganizerDto organizerDto;

    @BeforeEach
    void setUp() {
        organizer = new Organizer();
        organizer.setId(1L);
        organizer.setName("John Doe");

        organizerDto = new OrganizerDto();
        organizerDto.setId(1L);
        organizerDto.setName("John Doe");
    }

    @Test
    void testGetAllOrganizers() {
        when(organizerRepository.findAll()).thenReturn(List.of(organizer));
        when(organizerMapper.toDto(any(Organizer.class))).thenReturn(organizerDto);

        List<OrganizerDto> organizers = organizerService.getAllOrganizers();

        assertFalse(organizers.isEmpty());
        assertEquals(1, organizers.size());
        assertEquals("John Doe", organizers.get(0).getName());
    }

    @Test
    void testGetOrganizerById() {
        when(organizerRepository.findById(1L)).thenReturn(Optional.of(organizer));
        when(organizerMapper.toDto(any(Organizer.class))).thenReturn(organizerDto);

        OrganizerDto foundOrganizer = organizerService.getOrganizerById(1L);

        assertNotNull(foundOrganizer);
        assertEquals(1L, foundOrganizer.getId());
    }
}
