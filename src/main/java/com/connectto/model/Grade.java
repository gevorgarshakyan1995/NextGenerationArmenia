package com.connectto.model;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;

@Data
@Entity
public class Grade {
    @NotNull
    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "user_id", column = @Column(name = "user_id")),
            @AttributeOverride(name = "grade", column = @Column(name = "grade"))
    })
    private UserID userID;

}
