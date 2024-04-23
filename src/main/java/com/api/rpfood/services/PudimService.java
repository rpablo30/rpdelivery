package com.api.rpfood.services;

import com.api.rpfood.models.Pudim;
import com.api.rpfood.repositories.PudimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PudimService {

    private final PudimRepository pudimRepository;

    @Autowired
    public PudimService(PudimRepository pudimRepository) {
        this.pudimRepository = pudimRepository;
    }

    public List<Pudim> obterPudins() {
        return pudimRepository.findAll();
    }
}
