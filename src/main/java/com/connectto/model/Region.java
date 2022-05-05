package com.connectto.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "region")
    private String region;

    @JsonIgnore
    @OneToMany(mappedBy = "region")
    private List<User> userList;

    @JsonIgnore
    @OneToMany(mappedBy = "city")
    private List<City> city;

    @JsonIgnore
    @ManyToOne
    @JoinColumn
    private Country country;

}