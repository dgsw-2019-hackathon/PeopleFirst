package com.hackathon.hackathon.Repository;

import com.hackathon.hackathon.Domain.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Long> {
//    List<Location> findTop1ByUsernameOrderByCreated(String username);
}
