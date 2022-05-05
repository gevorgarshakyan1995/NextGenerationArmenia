package com.connectto.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "school")
    private String school;

    @JsonIgnore
    @OneToMany(mappedBy = "school")
    private List<User> userList;

    @JsonIgnore
    @ManyToOne
    @JoinColumn
    private City city;
}
