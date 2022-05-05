package com.connectto.services.implementations;


import com.connectto.model.Country;
import com.connectto.model.Region;
import com.connectto.repositores.RegionRepository;
import com.connectto.services.interfaces.RegionService;
import com.connectto.utils.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegionServiceImpl implements RegionService {
    @Autowired
    private RegionRepository regionRepository;

    @Override
    public List<Region> getall() {
        return regionRepository.findAll();
    }

    @Override
    public void save(Region region) {
        regionRepository.save(region);
    }

    @Override
    public void DeleteById(int id) {
        regionRepository.deleteById(id);
    }

    @Override
    public Region getById(int id) throws NotFoundException {
        Optional<Region> optional = regionRepository.findById(id);

        if (!optional.isPresent()) {
            throw new NotFoundException("not id region");
        }
        return optional.get();
    }

    @Override
    public void Urdate(int id, String region) throws NotFoundException {
        Region regUrdet = getById(id);
        regUrdet.setRegion(region);
        save(regUrdet);
    }

    @Override
    public List<Region> getbyRegion(String region) throws NotFoundException {
        return regionRepository.getAllByRegion(region);
    }

    @Override
    public List<Region> getAllByCountry(Country country) {
        return regionRepository.getAllByCountry(country);
    }
}
