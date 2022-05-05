package com.connectto.repositores;

import com.connectto.model.City;
import com.connectto.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CItyRepository extends JpaRepository<City, Integer> {

    List<City> getAllByCity (String city);

    List<City> getAllByRegion(Region region);
}
