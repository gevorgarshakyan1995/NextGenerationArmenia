package com.connectto.services.interfaces;


import com.connectto.model.Subject;
import com.connectto.utils.exception.NotFoundException;

import java.util.List;

public interface SubjectService {

    Subject getById(int id) throws NotFoundException;

    Subject getByName(String name)throws NotFoundException;

    List<Subject> getall();

    public void save(Subject subject);
}
