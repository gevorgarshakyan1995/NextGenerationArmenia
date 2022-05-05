package com.connectto.services.interfaces;

import com.connectto.model.Country;
import com.connectto.model.Region;
import com.connectto.utils.exception.NotFoundException;

import java.util.List;

public interface RegionService {

    List<Region> getall();

    void save(Region region);

    void DeleteById(int id);

    Region getById(int id) throws NotFoundException;

    void Urdate(int id, String region) throws NotFoundException;

    List<Region> getbyRegion(String region)throws NotFoundException;

    List<Region> getAllByCountry(Country country);
}
