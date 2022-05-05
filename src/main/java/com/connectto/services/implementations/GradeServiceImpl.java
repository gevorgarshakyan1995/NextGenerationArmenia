package com.connectto.services.implementations;

import com.connectto.model.Grade;


import com.connectto.model.UserID;
import com.connectto.repositores.GradeRepository;
import com.connectto.services.interfaces.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;

@Service
public class GradeServiceImpl implements GradeService {

    @Autowired
    private GradeRepository gradeRepository;


    @Override
    public List<Grade> getall() {
        Grade grade = new Grade();
        Example<Grade> songExample = Example.of(grade);
        return gradeRepository.findAll(songExample);
    }


    @Override
    public void save(List<Integer> grade_id, int user_id) {
        List<Grade> gradeList = new ArrayList<>();
        for (Integer integer_id : grade_id) {
            Grade grade = new Grade();
            UserID userID = new UserID();
            userID.setUser_id(user_id);
            userID.setGrade(integer_id);
            grade.setUserID(userID);
            gradeList.add(grade);
        }
        gradeRepository.saveAll(gradeList);
    }

    @Override
    public List<Grade> getbygradeID(int greate_id) {
        return gradeRepository.getByGradeID(greate_id);
    }

    @Override
    public List<Grade> getbyUserID(int user_id) {
        return gradeRepository.getByUserID(user_id);
    }

    @Override
    public void delete(int Grete, int UserID) {
        Grade grade = new Grade();
        UserID userID = new UserID();
        userID.setUser_id(UserID);
        userID.setGrade(Grete);
        grade.setUserID(userID);
        gradeRepository.delete(grade);
    }

    @Override
    @Transactional
    public Grade Urdate(int oldGrete, int oldUserID,int newGrete, int newUserID){
        Grade grade = new Grade();
        UserID userID = new UserID();
        userID.setUser_id(oldUserID);
        userID.setGrade(oldGrete);
        grade.setUserID(userID);
        gradeRepository.delete(grade);
        userID.setUser_id(newUserID);
        userID.setGrade(newGrete);
        grade.setUserID(userID);
        return gradeRepository.save(grade);
    }

}
