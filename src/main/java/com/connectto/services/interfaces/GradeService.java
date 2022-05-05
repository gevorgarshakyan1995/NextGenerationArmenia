package com.connectto.services.interfaces;

import com.connectto.model.Grade;
import java.util.List;

public interface GradeService {

    List<Grade> getall();

    void save(List<Integer> grade_id,int user_id);

    List<Grade> getbygradeID (int greate_id);

    List<Grade> getbyUserID (int greate_id);

    void delete(int Grete, int UserID);

    Grade Urdate(int oldGrete, int oldUserID,int newGrete, int newUserID);

}
