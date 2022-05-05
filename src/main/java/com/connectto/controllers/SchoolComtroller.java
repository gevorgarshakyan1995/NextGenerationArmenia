package com.connectto.controllers;

import com.connectto.model.School;
import com.connectto.services.interfaces.SchoolService;
import com.connectto.utils.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/School")
public class SchoolComtroller {
    @Autowired
    private SchoolService schoolService;

    @GetMapping
    ResponseEntity<List<School>> getAll() {
        return ResponseEntity.ok(schoolService.getall());
    }

    @GetMapping("{id}")
    ResponseEntity<School> getById(@PathVariable int id) throws NotFoundException {
        return ResponseEntity.ok(schoolService.getById(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> DeleteById(@PathVariable int id) {
        schoolService.DeleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> Urdate(@RequestParam("id") int id, @RequestParam("school") String school) throws NotFoundException {
        schoolService.Urdate(id, school);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    ResponseEntity<Void> save(@RequestBody School school) {
        schoolService.save(school);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/school")
    ResponseEntity<List<School>> getByschool(@RequestParam("school") String school) throws NotFoundException {
        return ResponseEntity.ok(schoolService.getAllBySchool(school));
    }

}
