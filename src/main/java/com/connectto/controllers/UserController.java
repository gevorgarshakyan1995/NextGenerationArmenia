package com.connectto.controllers;

import com.connectto.model.DTO.Request.UserSaveDtoReq;
import com.connectto.model.User;
import com.connectto.services.interfaces.UserService;
import com.connectto.utils.exception.BadRequestException;
import com.connectto.utils.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping("/number")
    ResponseEntity<User> getNumberphone(@RequestParam("number") String number) throws NotFoundException {
        return ResponseEntity.ok(userService.getPhoneNumber(number));
    }

    @GetMapping
    public ResponseEntity<List<User>> getall () throws NotFoundException {
        return ResponseEntity.ok(userService.getall());
    }


    @GetMapping("{id}")
    ResponseEntity<User> getById(@PathVariable int id) throws NotFoundException {
        return ResponseEntity.ok(userService.getById(id));
    }

    @GetMapping("/get-by-email")
    ResponseEntity<User> getByEmail(@RequestParam("email") String email) throws NotFoundException {
        return ResponseEntity.ok(userService.getBYEmail(email));
    }

    @DeleteMapping
    public ResponseEntity<Void> DeleteById(@RequestParam("id") int id) {
        userService.DeleteById(id);
        return ResponseEntity.ok().build();

    }

    @PutMapping
    public ResponseEntity<Void> Urdate(@RequestParam("id") int id, @RequestParam("lastname") String lestname, @RequestParam("firstname") String firstname) throws NotFoundException {
        userService.Urdate(id, lestname, firstname);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/get-all-by-name")
    public ResponseEntity<List<User>> getAllByName(@RequestParam("lastname") String lestname, @RequestParam("firstname") String firstname) {
        return ResponseEntity.ok(userService.getAllByLestnameAndFistname(lestname, firstname));
    }

    @PostMapping
    ResponseEntity<Void> save(@RequestBody UserSaveDtoReq userdto) throws NotFoundException, BadRequestException {
        if (userdto.getPassword() == userdto.getConfirPassword()) {
            userService.save(userdto);
        }else {
            throw new BadRequestException("password chacker ");
        }
        return ResponseEntity.ok().build();
    }


    @PostMapping("/reset-password")
    ResponseEntity<Void> ResetPasswordToken(@RequestParam("email") String Email) throws NotFoundException {
        userService.ResetPasswordToken(Email);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/reset-password")
    public ResponseEntity<User> ResetPassword(@RequestParam("token") String token, @RequestParam("password") String password) throws NotFoundException {
        return ResponseEntity.ok(userService.ResetPassword(token, password));
    }

    @PutMapping("/activate")
    public ResponseEntity<Void> activateUser(@RequestParam("token") String token) throws NotFoundException {
        userService.activateUser(token);
        return ResponseEntity.ok().build();
    }

}

