package com.api.rpfood.controllers;

import com.api.rpfood.models.Picole;
import com.api.rpfood.services.PicoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/picole")
@CrossOrigin(origins = "http://localhost:4200")
public class PicoleController {


    private final PicoleService picoleService;

    @Autowired
    public PicoleController(PicoleService picoleService) {
        this.picoleService = picoleService;
    }

    @GetMapping
    public ResponseEntity<List<Picole>> getAllPicoles() {
        List<Picole> picoles = picoleService.getAllPicoles();
        // Adicione logs para verificar
        System.out.println("Chamada para getAllPicoles. Número de picoles: " + picoles.size());
        return ResponseEntity.ok(picoles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Picole> getPicoleById(@PathVariable Long id) {
        Optional<Picole> picole = picoleService.getPicoleById(id);
        return picole.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Picole savePicole(@RequestBody Picole picole) {
        return picoleService.savePicole(picole);
    }

    @DeleteMapping("/{id}")
    public void deletePicole(@PathVariable Long id) {
        picoleService.deletePicole(id);
    }

}
