package com.hackathon.hackathon.Domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
public class Location {

    @GeneratedValue
    @Id
    private Long id;

    private String latitude;

    private String longitude;


    @CreationTimestamp
    private LocalDateTime created;

    public Location(String username, String latitude, String longitude, LocalDateTime created) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.created = created;
    }
}
