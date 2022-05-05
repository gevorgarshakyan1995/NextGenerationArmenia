package com.connectto.services.implementations;

import com.connectto.model.City;
import com.connectto.model.School;
import com.connectto.repositores.SchoolRepository;
import com.connectto.services.interfaces.SchoolService;
import com.connectto.utils.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SchoolServiceImpl implements SchoolService {
    @Autowired
    private SchoolRepository schoolRepository;

    @Override
    public List<School> getall() {
        return schoolRepository.findAll();
    }

    @Override
    public void save(School school) {
        schoolRepository.save(school);
    }

    @Override
    public void DeleteById(int id) {
        schoolRepository.deleteById(id);
    }

    @Override
    public School getById(int id) throws NotFoundException {
        Optional<School> optional = schoolRepository.findById(id);

        if (!optional.isPresent()) {
            throw new NotFoundException("not id school");
        }
        return optional.get();
    }

    @Override
    public void Urdate(int id, String school) throws NotFoundException {
        School school1yrd = schoolRepository.getById(id);
        school1yrd.setSchool(school);
        save(school1yrd);
    }

    @Override
    public List<School> getAllBySchool(String school) throws NotFoundException {
        return schoolRepository.getAllBySchool(school);
    }

    @Override
    public List<School> getAllByCity(City city) {
        return schoolRepository.getAllByCity(city);
    }
}
