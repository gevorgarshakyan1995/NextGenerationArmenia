package com.connectto.model.DTO.Request;

import com.connectto.enams.Role;
import com.connectto.model.*;
import com.sun.istack.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class UserSaveDtoReq {

    @NotNull
    private Long id;

    @NotNull
    private String email;

    @NotNull
    private String fistname;

    @NotNull
    private String lestname;

    @NotNull
    private String password;

    @NotNull
    private String ConfirmPassword;

    private String confirPassword;

    private String phoneNumber;

    @NotNull
    private Country country;

    @NotNull
    private Region region;

    private School school;

    private City city;

    private List<Subject> subject;

    @NotNull
    private Role role;

    private List<Integer> gradeList;


}
