package com.connectto.controllers;

import com.connectto.model.Grade;
import com.connectto.services.interfaces.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/grade")
public class GradeController {

    @Autowired
    private GradeService gradeService;

    @GetMapping
    ResponseEntity<List<Grade>> getAll() {
        return ResponseEntity.ok(gradeService.getall());
    }

    @GetMapping("/grade-id")
    ResponseEntity<List<Grade>> getbygradeID (@RequestParam("grade")int greate_id){
        return ResponseEntity.ok(gradeService.getbygradeID(greate_id));
    }

    @GetMapping("/user-id")
    ResponseEntity<List<Grade>> getbyUserID (@RequestParam("user_id")int user_id){
        return ResponseEntity.ok(gradeService.getbyUserID(user_id));
    }

    @DeleteMapping
    ResponseEntity<Void> delete(@RequestParam("grade")int Grete,@RequestParam("user_id")int UserID){
        gradeService.delete(Grete,UserID);
        return ResponseEntity.ok().build();
    }

}