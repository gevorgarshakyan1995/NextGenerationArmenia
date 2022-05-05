package com.connectto.controllers;

import com.connectto.model.*;
import com.connectto.services.interfaces.CityService;
import com.connectto.services.interfaces.RegionService;
import com.connectto.services.interfaces.SchoolService;
import com.connectto.services.interfaces.UserService;
import com.connectto.utils.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/checker")
public class SignUpCheckerController {

    @Autowired
    private UserService userService;

    @Autowired
    private CityService cityService;

    @Autowired
    private RegionService regionService;

    @Autowired
    private SchoolService schoolService;

    @PostMapping("/get-by-email")
    ResponseEntity<User> getByEmail(@RequestParam("email") String email) throws NotFoundException {
        return ResponseEntity.ok(userService.getBYEmail(email));
    }

    @PostMapping("/number")
    ResponseEntity<User> getNumberphone(@RequestParam("number") String number) throws NotFoundException {
        return ResponseEntity.ok(userService.getPhoneNumber(number));
    }

    @PostMapping("/city")
    ResponseEntity<List<City>> getCiti(@RequestBody Region region) {
        return ResponseEntity.ok(cityService.getAllByRegion(region));
    }

    @PostMapping("/region")
    ResponseEntity<List<Region>> getRegion(@RequestBody Country country) {
        return ResponseEntity.ok(regionService.getAllByCountry(country));
    }

    @PostMapping("/school")
    ResponseEntity<List<School>> getSchool(@RequestBody City city){
        return ResponseEntity.ok(schoolService.getAllByCity(city));
    }


}

