package fi.haagahelia.mel.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {

    List<Reservation> findByDirector1(String director1);
    
}