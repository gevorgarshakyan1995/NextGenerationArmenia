package com.connectto.services.implementations;

import com.connectto.model.City;
import com.connectto.model.Region;
import com.connectto.repositores.CItyRepository;
import com.connectto.services.interfaces.CityService;
import com.connectto.utils.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CItyRepository cityRepository;

    @Override
    public List<City> getall() {
        return cityRepository.findAll();
    }

    @Override
    public void save(City city) {
        cityRepository.save(city);
    }

    @Override
    public void DeleteById(int id) {
        cityRepository.deleteById(id);
    }

    @Override
    public City getById(int id) throws NotFoundException {
        Optional<City> optional = cityRepository.findById(id);

        if (!optional.isPresent()) {
            throw new NotFoundException("not id citi");
        }
        return optional.get();
    }

    @Override
    public void Urdate(int id, String city) throws NotFoundException {
        City city1ur = getById(id);
        city1ur.setCity(city);
        save(city1ur);
    }

    @Override
    public List<City> getbycity(String city) throws NotFoundException {
        return cityRepository.getAllByCity(city);
    }

    @Override
    public List<City> getAllByRegion(Region region) {
        return cityRepository.getAllByRegion(region);
    }
}
