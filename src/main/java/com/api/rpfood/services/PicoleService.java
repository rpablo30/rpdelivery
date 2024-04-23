package com.api.rpfood.services;

import com.api.rpfood.models.Picole;
import com.api.rpfood.repositories.PicoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PicoleService {


    private final PicoleRepository picoleRepository;

    @Autowired
    public PicoleService(PicoleRepository picoleRepository) {
        this.picoleRepository = picoleRepository;
    }

    public List<Picole> getAllPicoles() {
        List<Picole> picoles = picoleRepository.findAll();
        // Adicione logs para verificar
        System.out.println("Chamada para getAllPicoles. Número de picoles: " + picoles.size());

        for (Picole picole : picoles) {
            System.out.println("Picole serializado: " + picole);
        }

        return picoles;
    }

    public Optional<Picole> getPicoleById(Long id) {
        return picoleRepository.findById(id);
    }

    public Picole savePicole(Picole picole) {
        return picoleRepository.save(picole);
    }

    public void deletePicole(Long id) {
        picoleRepository.deleteById(id);
    }


}
