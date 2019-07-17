package com.hackathon.hackathon.Service;

import com.hackathon.hackathon.Domain.Medicine;
import com.hackathon.hackathon.Repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicineServiceInpl implements MedicineService {

    @Autowired
    private MedicineRepository medicineRepository;

    @Override
    public void medicine(Medicine medicine) {
        medicineRepository.save(medicine);
    }

    @Override
    public Medicine getMedicine(String username) {
//        return medicineRepository.findByUsername(username).get(0);
        return null;
    }
}
