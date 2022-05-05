package com.connectto.repositores;

import com.connectto.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "select u from User u where u.email = :email")
    User getByEmail(String email);

    User getByEmailAndPassword(String email, String password);

    @Query(value = "select u from User u where u.ResetPasswordToken = :token")
    User getByResetPasswordToken(String token);


    List<User> getAllByLestnameAndFistname(String lestname, String fistname);

    User getByPhoneNumber(String phoneNumber);

}
