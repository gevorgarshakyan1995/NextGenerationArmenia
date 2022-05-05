package com.connectto.repositores;


import com.connectto.model.City;
import com.connectto.model.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchoolRepository extends JpaRepository<School, Integer> {

    List<School> getAllBySchool (String school);

    List<School> getAllByCity (City city);
}
