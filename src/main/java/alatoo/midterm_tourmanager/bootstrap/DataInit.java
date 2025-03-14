package alatoo.midterm_tourmanager.bootstrap;

import alatoo.midterm_tourmanager.entities.Category;
import alatoo.midterm_tourmanager.entities.Location;
import alatoo.midterm_tourmanager.entities.Organizer;
import alatoo.midterm_tourmanager.entities.Tour;
import alatoo.midterm_tourmanager.repositories.CategoryRepository;
import alatoo.midterm_tourmanager.repositories.LocationRepository;
import alatoo.midterm_tourmanager.repositories.OrganizerRepository;
import alatoo.midterm_tourmanager.repositories.TourRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class DataInit {

    private final TourRepository tourRepository;
    private final CategoryRepository categoryRepository;
    private final LocationRepository locationRepository;
    private final OrganizerRepository organizerRepository;

    @PostConstruct
    public void init() {

//        part of code, where i make an organizers
        Organizer sunriseoshtravel = Organizer.builder()
                .name("SunriseOshTravel")
                .address("Osh city, Masaliev str., 25A")
                .phone("+996509552270")
                .build();

        Organizer aksaitravel = Organizer.builder()
                .name("Ak-SaiTravel")
                .address("Bishkek city")
                .phone("+996501234567")
                .build();

        Organizer pamirtravel = Organizer.builder()
                .name("PamirExpeditions")
                .address("Tashkent city")
                .phone("+998123465789")
                .build();

//        part of code where i make a categories
        Category trekking = Category.builder()
                .type("trekking")
                .build();

        Category cultural = Category.builder()
                .type("cultural")
                .build();

        Category climbing = Category.builder()
                .type("climbing")
                .build();

//        part of code where i make a locations
        Location southOfKyrgyzstan = Location.builder()
                .country("Kyrgyzstan")
                .build();

        Location peakLenin = Location.builder()
                .country("Kyrgyzstan")
                .build();

        Location jalalAbad = Location.builder()
                .country("Kyrgyzstan")
                .build();

//        part of code where i make a tour
        Tour tulparkul = Tour.builder()
                .title("Tulpar-Kul")
                .description("Visiting a tulpar-kul")
                .price(1800.)
                .locationOfTour(southOfKyrgyzstan)
                .categoryOfTour(cultural)
                .tourOrganizer(sunriseoshtravel)
                .build();

        Tour leninpeak = Tour.builder()
                .title("Lenin Peak")
                .description("Conquering a Lenin Peak")
                .price(2500.)
                .categoryOfTour(climbing)
                .locationOfTour(peakLenin)
                .tourOrganizer(aksaitravel)
                .build();

        Tour saryChelek = Tour.builder()
                .title("Sary-Chelek")
                .description("Trekking in Sary-Chelek reservoir")
                .price(1200.)
                .categoryOfTour(trekking)
                .locationOfTour(jalalAbad)
                .tourOrganizer(pamirtravel)
                .build();

        organizerRepository.save(sunriseoshtravel);
        organizerRepository.save(aksaitravel);
        organizerRepository.save(pamirtravel);

        categoryRepository.save(cultural);
        categoryRepository.save(climbing);
        categoryRepository.save(trekking);

        locationRepository.save(southOfKyrgyzstan);
        locationRepository.save(peakLenin);
        locationRepository.save(jalalAbad);

        tourRepository.save(tulparkul);
        tourRepository.save(leninpeak);
        tourRepository.save(saryChelek);
    }
}

