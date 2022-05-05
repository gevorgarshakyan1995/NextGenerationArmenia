package com.connectto.model;

import com.connectto.enams.Role;
import com.connectto.enams.Status;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "fist_name", nullable = false)
    private String fistname;

    @Column(name = "lest_name", nullable = false)
    private String lestname;

    @Column(name = "password", nullable = false)
    private String password;

    //  @Transient
    //  private String confirPassword;//ne sazdat column

    @Column(unique = true)
    private String phoneNumber;

    @Column(unique = true)
    private String ResetPasswordToken;

    @ManyToOne
    @JoinColumn
    private Region region;

    @ManyToOne
    @JoinColumn
    private School school;

    @ManyToOne
    @JoinColumn
    private City city;

    @ManyToOne
    @JoinColumn
    private Country country;

    @JoinColumn
    @ManyToMany
    private List<Subject> subject;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_status")
    private Status status;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "role")
    private Role role;

    @Column(name = "reset_token_req_age")
    private Long timeMillis;

}
