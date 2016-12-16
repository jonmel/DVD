package fi.haagahelia.mel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.mel.domain.User;
import fi.haagahelia.mel.domain.UserRepository;
import fi.haagahelia.mel.domain.Genre;
import fi.haagahelia.mel.domain.MemberStatus;
import fi.haagahelia.mel.domain.GenreRepository;
import fi.haagahelia.mel.domain.MemberStatusRepository;
import fi.haagahelia.mel.domain.DVDstore;
import fi.haagahelia.mel.domain.Reservation;
import fi.haagahelia.mel.domain.DVDstoreRepository;
import fi.haagahelia.mel.domain.ReservationRepository;

@SpringBootApplication
public class DVDstoreOnetoManyApplication {

	private static final Logger log = LoggerFactory.getLogger(DVDstoreOnetoManyApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DVDstoreOnetoManyApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(DVDstoreRepository dvdstorerepository , ReservationRepository reservationrepository  ,GenreRepository genrerepository , MemberStatusRepository memberstatusrepository  ,UserRepository userrepository) {
		return (args) -> {
			log.info("save a couple of info");
			genrerepository.save(new Genre("DRAMA"));
			genrerepository.save(new Genre("ACTION"));
			genrerepository.save(new Genre("ROMANCE"));
			
			dvdstorerepository.save(new DVDstore("TITANIC", "James Cameron" ,"2 hrs 15 mins" , "	Leonardo DiCaprio & Kate Winslet","10.00 $",genrerepository.findByName("DRAMA").get(0)));
			dvdstorerepository.save(new DVDstore("RAMBO I", "David Morrell" ,"1 hr 45 mins" , "Sylvester Stallone","05.00 $",genrerepository.findByName("ACTION").get(0)));
			dvdstorerepository.save(new DVDstore("LORD OF THE RINGS", "Peter Jackson" ,"2 hrs 58 mins" , "Elijah Wood & Ian McKellan","10.00 $",genrerepository.findByName("DRAMA").get(0)));
			dvdstorerepository.save(new DVDstore("BACK TO THE FUTURE", "Robert Zemeckis" ,"1 hr 56 mins" , "Michael J. Fox","05.00 $",genrerepository.findByName("ACTION").get(0)));
			dvdstorerepository.save(new DVDstore("THE GODFATHER", "Francis Ford Coppola" ,"2 hrs 55 mins" , "Marlon Brando & Al Pacino","10.00 $",genrerepository.findByName("DRAMA").get(0)));
			dvdstorerepository.save(new DVDstore("RAMBO II", "George P. Cosmatos" ,"1 hr 36 mins" , "Sylvester Stallone","05.00 $",genrerepository.findByName("ACTION").get(0)));
			
			
			memberstatusrepository.save(new MemberStatus("MEMBER"));
			memberstatusrepository.save(new MemberStatus("NOT A MEMBER"));
			
			
			reservationrepository.save(new Reservation("HAROLD and KUMAR 4", "Danny Leiner" ,"John Cho & Kal Penn" , "December 25, 2016","10.00 $",memberstatusrepository.findByName1("MEMBER").get(0)));
			

			
			
			
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER" );
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");

			userrepository.save(user1);
			userrepository.save(user2);

			
			log.info("fetch all Books");
			for (DVDstore DVDstore : dvdstorerepository.findAll()) {
				log.info(DVDstore.toString());
			}

		};
	}
}
