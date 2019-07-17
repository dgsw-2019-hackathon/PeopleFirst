package com.hackathon.hackathon.Domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
public class Medicine {

    @GeneratedValue
    @Id
    private Long id;

    private String time;

    public Medicine(String username, String time, String medicine) {
        this.time = time;
    }

}
