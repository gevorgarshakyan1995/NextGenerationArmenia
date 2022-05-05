package com.connectto.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name",unique = true, nullable = false)
    private String name;

    @JsonIgnore
    @ManyToMany (mappedBy = "subject")
    private List<User> users;
}
