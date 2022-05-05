package com.connectto.services.implementations;

import com.connectto.model.Country;
import com.connectto.repositores.CountyRepository;
import com.connectto.services.interfaces.CountyService;
import com.connectto.utils.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CountryServiceImpl implements  CountyService{

    @Autowired
    private CountyRepository countyRepository;

    @Override
    public List<Country> getall() {
        return countyRepository.findAll();
    }

    @Override
    public void save(Country country) {
        countyRepository.save(country);
    }

    @Override
    public void DeleteById(int id) {
        countyRepository.deleteById(id);
    }

    @Override
    public Country getById(int id) throws NotFoundException {
        Optional<Country> optional = countyRepository.findById(id);

        if (!optional.isPresent()) {
            throw new NotFoundException("not id counter");
        }
        return optional.get();
    }

    @Override
    public void Urdate(int id, String Country) throws NotFoundException {
        Country Countryl1yrd = countyRepository.getById(id);
        Countryl1yrd.setCountry(Country);
        save(Countryl1yrd);
    }

    @Override
    public List<Country> getAllByCountry(String Country) throws NotFoundException {
        return countyRepository.getAllByCountry(Country);
    }
}
