package com.scaler.Splitwise.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@Entity(name = "SPLITWISE_USER")
public class User extends BaseModel {
    private String name;
    private String email;
    private String phoneNumber;
    @ManyToMany
    private List<Group> groups;
}
