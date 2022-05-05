package com.connectto.services.interfaces;

import com.connectto.model.DTO.Request.UserSaveDtoReq;
import com.connectto.model.User;
import com.connectto.utils.exception.BadRequestException;
import com.connectto.utils.exception.NotFoundException;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User getById(int id) throws NotFoundException;

    public List<User> getall() throws NotFoundException;

    public void save(UserSaveDtoReq UserDto) throws NotFoundException, BadRequestException;

    public void DeleteById(int id);

    public void Urdate(int id, String listname ,String frstname ) throws NotFoundException;

    public User getBYEmail(String email) throws NotFoundException;

    List<User> getAllByLestnameAndFistname (String lestname ,String fistname);

    void ResetPasswordToken(String email) throws NotFoundException;

    User ResetPassword(String token, String password) throws NotFoundException;

    User getPhoneNumber(String number);

    void activateUser (String token) throws NotFoundException;

}
