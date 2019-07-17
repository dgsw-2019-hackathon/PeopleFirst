package com.hackathon.hackathon.Repository;

import com.hackathon.hackathon.Domain.HeartRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HeartRateRepository extends JpaRepository<HeartRate, Long> {
    List<HeartRate> findTop1ByOrderByIdDesc();
}
