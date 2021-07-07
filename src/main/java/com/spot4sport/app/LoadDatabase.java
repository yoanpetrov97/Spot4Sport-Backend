package com.spot4sport.app;

import com.spot4sport.app.model.Court;
import com.spot4sport.app.model.Event;
import com.spot4sport.app.model.Person;
import com.spot4sport.app.model.Reservation;
import com.spot4sport.app.repository.CourtRepository;
import com.spot4sport.app.repository.EventRepository;
import com.spot4sport.app.repository.PersonRepository;
import com.spot4sport.app.repository.ReservationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
    private final Court court1 = new Court("Спортен център \"Европа\"",
          "3 игрища за футбол, 1 игрище за баскетбол, 2 тенис корта",
          "ж.к. \"Стрелбище\", ул. Нишава 129");
    private final Court court2 = new Court("Спортна зала \"Fireball\"",
          "1 зала за волейбол, 2 бадминтон корта, 1 зала за скуош, 4 тенис маси",
          "Цариградско шосе 133, БИЦ-ИЗОТ корпус 4");
    private final Person person1 = new Person("Илън Мъск", "Мъж",
          "Футбол - 7/10, Волейбол - 5/10", 50);
    private final Person person2 = new Person("Георги Георгиев", "Мъж",
          "Баскетбол - 8/10, Тенис на корт - 3/10", 24);
    private final Person person3 = new Person("Ивана Иванова", "Жена",
          "Волейбол - 8/10, Тенис на маса - 6/10", 19);

    @Bean
    CommandLineRunner initCourtDatabase(CourtRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Court("Спортна зала \"Христо Ботев\"",
                  "1 зала за волейбол",
                  "ж.к. \"Студентски град\"")));
            log.info("Preloading " + repository.save(court2));
            log.info("Preloading " + repository.save(new Court("Спортен център \"Dream body\"",
                  "1 зала за баскетбол, 1 зала за футбол",
                  "Черни връх 11")));
            log.info("Preloading " + repository.save(this.court1));
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

    @Bean
    CommandLineRunner initPersonDatabase(PersonRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(person1));
            log.info("Preloading " + repository.save(this.person2));
            log.info("Preloading " + repository.save(this.person3));
            log.info("Preloading " + repository.save(new Person("Димитър Димитров", "Мъж",
                  "Тенис на корт - 8/10, Баскетбол - 6/10", 21)));
        };
    }

    @Bean
    CommandLineRunner initReservationDatabase(ReservationRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Reservation(this.court1, this.person2,
                  "14.07.2021г. - 16:00", "Футбол", 14)));
            log.info("Preloading " + repository.save(new Reservation(this.court2, this.person3,
                  "20.07.2021г. - 18:00", "Волейбол", 12)));
        };
    }

    @Bean
    CommandLineRunner initEventDatabase(EventRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Event("Ритане в Европата", this.court1, this.person2,
                  "08.07.2021г. - 16:00", "Футбол", 14)));
            log.info("Preloading " + repository.save(new Event("Волейболче", this.court2, this.person3,
                  "10.07.2021г. - 18:00", "Волейбол", 12)));
        };
    }
}
