package com.connectto.services.interfaces;

import com.connectto.model.City;
import com.connectto.model.School;
import com.connectto.utils.exception.NotFoundException;

import java.util.List;

public interface SchoolService {
    List<School> getall();

    void save(School school);

    void DeleteById(int id);

    School getById(int id) throws NotFoundException;

    void Urdate(int id, String school) throws NotFoundException;

    List<School> getAllBySchool(String school)throws NotFoundException;

    List<School> getAllByCity (City city);
}
