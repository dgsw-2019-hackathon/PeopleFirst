package com.hackathon.hackathon.Domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
public class HeartRate {

    @GeneratedValue
    @Id
    private Long id;

    private String heartRate;

    public HeartRate(String username, String heartRate) {
        this.heartRate = heartRate;
    }
}
