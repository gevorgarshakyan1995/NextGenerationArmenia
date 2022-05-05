package com.connectto.repositores;



import com.connectto.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountyRepository extends JpaRepository<Country, Integer> {

    List<Country> getAllByCountry (String country);

}
