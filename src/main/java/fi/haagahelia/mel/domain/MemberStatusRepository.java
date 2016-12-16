package fi.haagahelia.mel.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface MemberStatusRepository extends CrudRepository<MemberStatus, Long> {

    List<MemberStatus> findByName1(String name1);
    
}
