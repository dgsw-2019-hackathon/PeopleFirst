package com.hackathon.hackathon.Domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
public class User {

    @GeneratedValue
    @Id
    private Long id;

    private String username;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    private String name;

    private String parent;


    public User(String username, String password, String name, String phoneNumber, String parent) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.parent = parent;
    }
}
