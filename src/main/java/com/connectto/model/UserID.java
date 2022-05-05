package com.connectto.model;

import lombok.Data;
import org.springframework.data.annotation.Transient;

import javax.persistence.Embeddable;
import java.io.Serializable;
@Data
@Embeddable
public class UserID implements Serializable  {

    private int grade;

    private int user_id;

}
