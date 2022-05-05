package com.connectto.services.interfaces;

import com.connectto.model.City;
import com.connectto.model.Region;
import com.connectto.utils.exception.NotFoundException;

import java.util.List;

public interface CityService {

    List<City> getall();

    void save(City city);

    void DeleteById(int id);

    City getById(int id) throws NotFoundException;

    void Urdate(int id, String city) throws NotFoundException;

    List<City> getbycity(String city)throws NotFoundException;

    List<City> getAllByRegion(Region region);
}
