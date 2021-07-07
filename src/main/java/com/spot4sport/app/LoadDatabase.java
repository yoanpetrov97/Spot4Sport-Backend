package com.spot4sport.app;

import com.spot4sport.app.model.Court;
import com.spot4sport.app.repository.CourtRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initCourtDatabase(CourtRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Court("Спортна зала \"Христо Ботев\"",
                  "1 зала за волейбол",
                  "ж.к. \"Студентски град\"")));
            log.info("Preloading " + repository.save(new Court("Спортна зала \"Fireball\"",
                  "1 зала за волейбол, 2 бадминтон корта, 1 зала за скуош, 4 тенис маси",
                  "Цариградско шосе 133, БИЦ-ИЗОТ корпус 4")));

            log.info("Preloading " + repository.save(new Court("Спортен център \"Dream body\"",
                  "1 зала за баскетбол, 1 зала за футбол",
                  "Черни връх 11")));
            log.info("Preloading " + repository.save(new Court("Спортен център \"Европа\"",
                  "3 игрища за футбол, 1 игрище за баскетбол, 2 тенис корта",
                    "ж.к. \"Стрелбище\", ул. Нишава 129")));
            log.info("Preloading " + repository.save(new Court("Спортна зала \"Раковски\"",
                    "1 игрище за футбол, 1 игрище за баскетбол, 1 тенис корт",
                    "бул. България 5")));
            log.info("Preloading " + repository.save(new Court("Спортен център \"Лозенец\"",
                    "2 игрища за волейбол, 1 игрище за баскетбол, 4 тенис корта, 1 игрище за бадминтон",
                    "бул. Джеймс Баучер 9")));
            log.info("Preloading " + repository.save(new Court("Спортен център \"Кристал\"",
                    "1 игрище за футбол, 2 игрища за баскетбол, 2 игрища за бадминтон",
                    "бул. Ломско шосе 209")));
            log.info("Preloading " + repository.save(new Court("Спортен център \"Актив\"",
                    "1 игрище за футбол, 1 игрище за баскетбол, 1 тенис корт",
                    "ул. Солун 59Б")));
        };
    }
}
