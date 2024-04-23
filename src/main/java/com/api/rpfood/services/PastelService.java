package com.api.rpfood.services;

import com.api.rpfood.models.Pastel;
import com.api.rpfood.repositories.PastelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PastelService {

    private final PastelRepository pastelRepository;

    @Autowired
    public PastelService(PastelRepository pastelRepository) {
        this.pastelRepository = pastelRepository;
    }

    public List<Pastel> obterTodosPasteis() {
        return pastelRepository.findAll();
    }
}
