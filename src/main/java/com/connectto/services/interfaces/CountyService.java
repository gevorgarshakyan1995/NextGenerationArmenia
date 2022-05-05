package com.connectto.services.interfaces;


import com.connectto.model.Country;
import com.connectto.utils.exception.NotFoundException;

import java.util.List;

public interface CountyService {
    List<Country> getall();

    void save(Country country);

    void DeleteById(int id);

    Country getById(int id) throws NotFoundException;

    void Urdate(int id, String country) throws NotFoundException;

    List<Country> getAllByCountry(String country)throws NotFoundException;
}
