package com.api.rpfood.services;

import com.api.rpfood.models.Refrigerante;
import com.api.rpfood.repositories.RefrigeranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RefrigeranteService {

    private final RefrigeranteRepository refrigeranteRepository;

    @Autowired
    public RefrigeranteService(RefrigeranteRepository refrigeranteRepository) {
        this.refrigeranteRepository = refrigeranteRepository;
    }

    public List<Refrigerante> getAllRefrigerantes() {
        List<Refrigerante> refrigerantes = refrigeranteRepository.findAll();
        // Adicione logs para verificar
        System.out.println("Chamada para getAllRefrigerantes. Número de refrigerantes: " + refrigerantes.size());

        for (Refrigerante refrigerante : refrigerantes) {
            System.out.println("Refrigerante serializado: " + refrigerante);
        }

        return refrigerantes;
    }

    public Optional<Refrigerante> getRefrigeranteById(Long id) {
        return refrigeranteRepository.findById(id);
    }

    public Refrigerante saveRefrigerante(Refrigerante refrigerante) {
        return refrigeranteRepository.save(refrigerante);
    }

    public void deleteRefrigerante(Long id) {
        refrigeranteRepository.deleteById(id);
    }
}
