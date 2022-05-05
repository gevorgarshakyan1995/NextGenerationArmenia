package com.connectto.controllers;

import com.connectto.model.City;
import com.connectto.services.interfaces.CityService;
import com.connectto.utils.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/city")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping
    ResponseEntity<List<City>> getAll() {
        return ResponseEntity.ok(cityService.getall());
    }

    @GetMapping("{id}")
    ResponseEntity<City> getById(@PathVariable int id) throws NotFoundException {
        return ResponseEntity.ok(cityService.getById(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> DeleteById(@PathVariable int id) {
        cityService.DeleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> Urdate(@RequestParam("id") int id, @RequestParam("city") String city) throws NotFoundException {
        cityService.Urdate(id, city);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    ResponseEntity<Void> save(@RequestBody City city) {
        cityService.save(city);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/city")
    ResponseEntity<List<City>> getByschool(@RequestParam("city") String city) throws NotFoundException {
        return ResponseEntity.ok(cityService.getbycity(city));
    }
}
