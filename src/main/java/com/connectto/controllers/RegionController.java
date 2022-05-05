package com.connectto.controllers;


import com.connectto.model.Region;
import com.connectto.services.interfaces.RegionService;
import com.connectto.utils.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/region")
public class RegionController {

    @Autowired
    private RegionService regionService;

    @GetMapping
    ResponseEntity<List<Region>> getAll() {
        return ResponseEntity.ok(regionService.getall());
    }

    @GetMapping("{id}")
    ResponseEntity<Region> getById(@PathVariable int id) throws NotFoundException {
        return ResponseEntity.ok(regionService.getById(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> DeleteById(@PathVariable int id) {
        regionService.DeleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> Urdate(@RequestParam("id") int id, @RequestParam("region") String region) throws NotFoundException {
        regionService.Urdate(id, region);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    ResponseEntity<Void> save(@RequestBody Region region) {
        regionService.save(region);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/region")
    ResponseEntity<List<Region>> getByschool(@RequestParam("region") String region) throws NotFoundException {
        return ResponseEntity.ok(regionService.getbyRegion(region));
    }
}


