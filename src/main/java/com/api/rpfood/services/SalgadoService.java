package com.api.rpfood.services;

import com.api.rpfood.models.Salgado;
import com.api.rpfood.repositories.SalgadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalgadoService {

    private final SalgadoRepository salgadoRepository;

    @Autowired
    public SalgadoService(SalgadoRepository salgadoRepository) {
        this.salgadoRepository = salgadoRepository;
    }

    public List<Salgado> obterSalgados() {
        List<Salgado> salgados = salgadoRepository.findAll();
        System.out.println("Chamada para obterSalgados. Número de salgados: " + salgados.size());

        for (Salgado salgado : salgados) {
            System.out.println("Salgado serializado: " + salgado);
        }

        return salgados;
    }

    public Optional<Salgado> obterSalgadoPorId(Long id) {
        return salgadoRepository.findById(id);
    }

    public Salgado salvarSalgado(Salgado salgado) {
        return salgadoRepository.save(salgado);
    }

    public void deletarSalgado(Long id) {
        salgadoRepository.deleteById(id);
    }

}
