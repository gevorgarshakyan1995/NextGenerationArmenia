package com.connectto.repositores;

import com.connectto.model.Grade;
import com.connectto.model.UserID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface GradeRepository extends JpaRepository<Grade,UserID> {

    @Query(nativeQuery = true, value = "SELECT * FROM grade WHERE grade = ?")
    List<Grade> getByGradeID (@Param("grade") int grade);

    @Query(nativeQuery = true, value = "SELECT * FROM grade WHERE user_id = ?")
    List<Grade> getByUserID (@Param("user_id") int user_id) ;


}
