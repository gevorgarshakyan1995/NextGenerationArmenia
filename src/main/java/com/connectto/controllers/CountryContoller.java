package com.connectto.controllers;

import com.connectto.model.Country;
import com.connectto.services.interfaces.CountyService;
import com.connectto.utils.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value = "/country")
public class CountryContoller {

        @Autowired
        private CountyService countyService;

        @GetMapping
        ResponseEntity<List<Country>> getAll() {
            return ResponseEntity.ok(countyService.getall());
        }

        @GetMapping("{id}")
        ResponseEntity<Country> getById(@PathVariable int id) throws NotFoundException {
            return ResponseEntity.ok(countyService.getById(id));
        }

        @DeleteMapping("{id}")
        public ResponseEntity<Void> DeleteById(@PathVariable int id) {
            countyService.DeleteById(id);
            return ResponseEntity.ok().build();
        }

        @PutMapping
        public ResponseEntity<Void> Urdate(@RequestParam("id") int id, @RequestParam("Country") String country) throws NotFoundException {
            countyService.Urdate(id, country);
            return ResponseEntity.ok().build();
        }

        @PostMapping
        ResponseEntity<Void> save(@RequestBody Country country) {
            countyService.save(country);
            return ResponseEntity.ok().build();
        }

        @GetMapping("/country")
        ResponseEntity<List<Country>> getByschool(@RequestParam("city") String country) throws NotFoundException {
            return ResponseEntity.ok(countyService.getAllByCountry(country));
        }
}
