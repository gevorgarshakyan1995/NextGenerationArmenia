package com.connectto.repositores;



import com.connectto.model.Country;
import com.connectto.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegionRepository extends JpaRepository<Region, Integer> {

    List<Region> getAllByRegion (String region);

    List<Region> getAllByCountry(Country country);
}
