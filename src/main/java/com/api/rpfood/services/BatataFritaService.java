package com.api.rpfood.services;

import com.api.rpfood.models.Batatafrita;
import com.api.rpfood.repositories.BatataFritaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BatataFritaService {

    private final BatataFritaRepository batataFritaRepository;


    @Autowired
    public BatataFritaService(BatataFritaRepository batataFritaRepository) {
        this.batataFritaRepository = batataFritaRepository;
    }

    public List<Batatafrita> obterBatatasFritas() {
        List<Batatafrita> batatasFritas = batataFritaRepository.findAll();
        // Adicione logs para verificar
        System.out.println("Chamada para obterBatatasFritas. Número de batatas fritas: " + batatasFritas.size());

        for (Batatafrita batataFrita : batatasFritas) {
            System.out.println("Batata Frita serializada: " + batataFrita);
        }

        return batatasFritas;
    }

    public Optional<Batatafrita> obterBatataFritaPorId(Long id) {
        return batataFritaRepository.findById(id);
    }

    public Batatafrita salvarBatataFrita(Batatafrita batataFrita) {
        return batataFritaRepository.save(batataFrita);
    }

    public void deletarBatataFrita(Long id) {
        batataFritaRepository.deleteById(id);
    }



}
