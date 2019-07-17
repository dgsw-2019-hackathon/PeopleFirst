package com.hackathon.hackathon.Repository;

import com.hackathon.hackathon.Domain.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicineRepository extends JpaRepository<Medicine, Long> {
//    List<Medicine> findByUsername(String username);
}
