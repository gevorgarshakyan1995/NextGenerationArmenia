package com.connectto.services.implementations;


import com.connectto.model.Subject;
import com.connectto.model.User;
import com.connectto.repositores.SubjectRepository;
import com.connectto.services.interfaces.SubjectService;
import com.connectto.utils.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;


    @Override
    public Subject getById(int id) throws NotFoundException {
        Optional<Subject> optionalSubject = subjectRepository.findById(id);

        if (!optionalSubject.isPresent()) {
            throw new NotFoundException("not id");
        }
        return optionalSubject.get();
    }

    @Override
    public Subject getByName(String name)throws NotFoundException {
        return subjectRepository.getAllByName(name);
    }

    @Override
    public List<Subject> getall() {
        return subjectRepository.findAll();
    }


    @Override
    public void save(Subject subject){
        subjectRepository.save(subject);
    }


}
