package com.api.rpfood.services;

import com.api.rpfood.models.FoodModel;
import com.api.rpfood.repositories.FoodRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
public class FoodService {

    final FoodRepository foodRepository;

    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    @Transactional
    public FoodModel save(FoodModel foodModel) {
        return foodRepository.save(foodModel);
    }

    public boolean existsByLicensePlateCar(String licensePlateCar) {
        return foodRepository.existsByLicensePlateCar(licensePlateCar);
    }

    public boolean existsByParkingSpotNumber(String parkingSpotNumber) {
        return foodRepository.existsByParkingSpotNumber(parkingSpotNumber);
    }

    public boolean existsByApartmentAndBlock(String apartment, String block) {
        return foodRepository.existsByApartmentAndBlock(apartment, block);
    }

    public Page<FoodModel> findAll(Pageable pageable) {
        return foodRepository.findAll(pageable);
    }

    public Optional<FoodModel> findById(UUID id) {
        return foodRepository.findById(id);
    }

    @Transactional
    public void delete(FoodModel foodModel) {
        foodRepository.delete(foodModel);
    }
}
