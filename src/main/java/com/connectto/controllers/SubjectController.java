package com.connectto.controllers;

import com.connectto.model.Subject;
import com.connectto.model.User;
import com.connectto.services.interfaces.SubjectService;
import com.connectto.utils.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @GetMapping
    ResponseEntity<List<Subject>> getAll()  {
        return ResponseEntity.ok(subjectService.getall());
    }

    @GetMapping("/name")
    ResponseEntity<Subject> getByNumber(@RequestParam("name") String name)  throws NotFoundException {
        return ResponseEntity.ok(subjectService.getByName(name));
    }


    @GetMapping("{id}")
    ResponseEntity<Subject> getById(@PathVariable int id) throws NotFoundException {
        return ResponseEntity.ok(subjectService.getById(id));
    }
}
