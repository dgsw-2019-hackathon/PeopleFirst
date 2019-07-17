package com.hackathon.hackathon.Service;

import com.hackathon.hackathon.Domain.Medicine;

public interface MedicineService {

    void medicine(Medicine medicine);

    Medicine getMedicine(String username);
}
