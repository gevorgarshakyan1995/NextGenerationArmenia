package com.connectto.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "city")
    private String city;

    @JsonIgnore
    @OneToMany(mappedBy = "city")
    private List<User> userList;

    @JsonIgnore
    @OneToMany(mappedBy = "school")
    private List<School> school;

    @JsonIgnore
    @ManyToOne
    @JoinColumn
    private Region region;

}
