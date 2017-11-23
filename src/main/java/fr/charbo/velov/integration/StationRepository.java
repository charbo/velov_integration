package fr.charbo.velov.integration;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface StationRepository extends CrudRepository<StationEntity, StationKey> {
	
	@Query(value = "select s.* from station s left outer join station s2 on s2.ID_STATION = s.ID_STATION and s2.ID > s.ID where s2.ID_STATION is null and s.ID_STATION = ?1", nativeQuery = true)
    StationEntity findMaxDateByStationKeyIdStation(String idStation);

}
