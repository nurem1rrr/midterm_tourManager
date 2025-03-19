package alatoo.midterm_tourmanager.mapperTest;

import alatoo.midterm_tourmanager.dto.OrganizerDto;
import alatoo.midterm_tourmanager.entities.Organizer;
import alatoo.midterm_tourmanager.mappers.OrganizerMapper;
import alatoo.midterm_tourmanager.mappers.OrganizerMapperImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrganizerMapperTest {

    private final OrganizerMapper organizerMapper = new OrganizerMapperImpl();

    @Test
    void testToDto() {
        Organizer organizer = new Organizer();
        organizer.setId(1L);
        organizer.setName("Best Travel");

        OrganizerDto organizerDto = organizerMapper.toDto(organizer);

        assertNotNull(organizerDto);
        assertEquals(1L, organizerDto.getId());
        assertEquals("Best Travel", organizerDto.getName());
    }

    @Test
    void testToEntity() {
        OrganizerDto organizerDto = new OrganizerDto();
        organizerDto.setId(2L);
        organizerDto.setName("Sunrise Tours");

        Organizer organizer = organizerMapper.toEntity(organizerDto);

        assertNotNull(organizer);
        assertEquals(2L, organizer.getId());
        assertEquals("Sunrise Tours", organizer.getName());
    }
}
