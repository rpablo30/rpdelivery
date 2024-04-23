package com.api.rpfood.services;


import com.api.rpfood.models.CachorroQuente;
import com.api.rpfood.repositories.CachorroQuenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CachorroQuenteService {

    private final CachorroQuenteRepository cachorroQuenteRepository;

    @Autowired
    public CachorroQuenteService(CachorroQuenteRepository cachorroQuenteRepository) {
        this.cachorroQuenteRepository = cachorroQuenteRepository;
    }

    public List<CachorroQuente> obterTodosCachorrosQuentes() {
        return cachorroQuenteRepository.findAll();
    }

}
