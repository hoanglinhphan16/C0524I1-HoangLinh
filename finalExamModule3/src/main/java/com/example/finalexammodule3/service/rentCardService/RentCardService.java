package com.example.finalexammodule3.service.rentCardService;

import com.example.finalexammodule3.model.RentCard;
import com.example.finalexammodule3.repository.rentCardRepo.IRentCardRepo;
import com.example.finalexammodule3.repository.rentCardRepo.RentCardRepo;

public class RentCardService implements IRentCardService{
    private IRentCardRepo rentCardRepo = new RentCardRepo();

    @Override
    public void rentCard(RentCard rentCard) {
        rentCardRepo.rentCard(rentCard);
    }
}
