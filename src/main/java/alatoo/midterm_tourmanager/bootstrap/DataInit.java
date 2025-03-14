package alatoo.midterm_tourmanager.bootstrap;

import alatoo.midterm_tourmanager.entities.Tour;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


@Component
public class DataInit implements ApplicationRunner {


    @Override
    public void run(ApplicationArguments args) throws Exception {
        Tour tour = Tour.builder()
                .id(1L)
                .title("Tulpar-Kul")
                .description("Visiting a tulpar-kul lake and Lenin peak")
                .price(1800.0)
                .build();


    }
}
