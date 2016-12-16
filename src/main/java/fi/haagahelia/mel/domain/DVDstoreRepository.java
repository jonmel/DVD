package fi.haagahelia.mel.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface DVDstoreRepository extends CrudRepository<DVDstore, Long> {

    List<DVDstore> findByDirector(String director);
    
}