package com.connectto.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "country")
    private String country;

    @JsonIgnore
    @OneToMany(mappedBy = "country")
    private List<User> userList;

    @JsonIgnore
    @OneToMany(mappedBy = "country")
    private List<Region> region;


}
