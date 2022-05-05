package com.connectto.services.implementations;

import com.connectto.enams.Status;
import com.connectto.model.DTO.Request.UserSaveDtoReq;
import com.connectto.model.User;
import com.connectto.repositores.UserRepository;
import com.connectto.services.interfaces.*;
import com.connectto.utils.UserHelper.MailSender;
import com.connectto.utils.exception.BadRequestException;
import com.connectto.utils.exception.NotFoundException;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GradeService gradeService;

    @Autowired
    private MailSender mailSender;

    @Override
    public User getById(int id) throws NotFoundException {
        Optional<User> optionalUser = userRepository.findById((long) id);

        if (!optionalUser.isPresent()) {
            throw new NotFoundException("not id");
        }
        return optionalUser.get();
    }


    @Override
    public List<User> getall() throws NotFoundException {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public void save(UserSaveDtoReq userDto) throws BadRequestException {
        User user = new User();
        User user1 = userRepository.getByEmail(userDto.getEmail());
        User user2 = userRepository.getByPhoneNumber(userDto.getPhoneNumber());
        if(user2 != null &&  user1 != null){
            throw new BadRequestException("mail or Nimber Phone is repeated");
        }
        String token = RandomString.make(10);
        Long timeMillis = System.currentTimeMillis();

        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setLestname(userDto.getLestname());
        user.setFistname(userDto.getFistname());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setSubject(userDto.getSubject());
        user.setRole(userDto.getRole());
        user.setCity(userDto.getCity());
        user.setRegion(userDto.getRegion());
        user.setSchool(userDto.getSchool());
        user.setStatus(Status.BANNED);
        user.setResetPasswordToken(token);
        user.setTimeMillis(timeMillis);

        user = userRepository.save(user);

        if (userDto.getGradeList()!=null) {
            int id_user = Integer.parseInt(String.valueOf(user.getId()));
            gradeService.save(userDto.getGradeList(), id_user);
        }
        String sobject = "Registr token";

        mailSender.tokenSimpleMessage(user.getEmail(),sobject,user.getResetPasswordToken());
    }

    @Override
    public void DeleteById(int id) {
        userRepository.deleteById((long) id);
    }

    @Override
    public User getPhoneNumber(String number) {
        return userRepository.getByPhoneNumber(number);
    }

    @Override
    public void activateUser(String token) throws NotFoundException {
        User user = userRepository.getByResetPasswordToken(token);
        if (user == null) {
            throw new NotFoundException();
        }

        Long timeMillis = System.currentTimeMillis();
        long timeUserON = timeMillis - user.getTimeMillis();
        if (timeUserON < 120000) {
            user.setStatus(Status.ACTIVE);
            user.setResetPasswordToken(null);
            user.setTimeMillis(null);
            userRepository.save(user);
        } else {
            user.setResetPasswordToken(RandomString.make(10));
            user.setTimeMillis(System.currentTimeMillis());
            userRepository.save(user);

            mailSender.tokenSimpleMessage(user.getEmail(),"NOW TOKEN",user.getResetPasswordToken());
            throw new NotFoundException("NOW TOKEN");
        }
    }


    @Override
    public void Urdate(int id, String listname, String frstname) throws NotFoundException {
        User user = getById(id);
        user.setFistname(frstname);
        user.setLestname(listname);
        userRepository.save(user);
    }

    @Override
    public User getBYEmail(String email) throws NotFoundException {
        User user = userRepository.getByEmail(email);

        if (user == null) {
            throw new NotFoundException("User not found");
        }
        return user;
    }

    @Override
    public List<User> getAllByLestnameAndFistname(String lestname, String fistname) {
        return userRepository.getAllByLestnameAndFistname(lestname, fistname);
    }


    @Override
    public void ResetPasswordToken(String email) throws NotFoundException {

    }

    @Override
    public User ResetPassword(String token, String password) throws NotFoundException {
        return null;
    }
}
