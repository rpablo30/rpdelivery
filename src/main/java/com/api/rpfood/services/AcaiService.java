package com.api.rpfood.services;

import com.api.rpfood.models.Acai;
import com.api.rpfood.repositories.AcaiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AcaiService {

    private final AcaiRepository acaiRepository;

    @Autowired
    public AcaiService(AcaiRepository acaiRepository) {
        this.acaiRepository = acaiRepository;
    }

    public List<Acai> getAllAcais() {
        return acaiRepository.findAll();
    }

    public Optional<Acai> getAcaiById(Long id) {
        return acaiRepository.findById(id);
    }

    public Acai saveAcai(Acai acai) {
        return acaiRepository.save(acai);
    }

    public void deleteAcai(Long id) {
        acaiRepository.deleteById(id);
    }

}
