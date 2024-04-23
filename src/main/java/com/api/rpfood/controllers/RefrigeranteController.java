package com.api.rpfood.controllers;

import com.api.rpfood.models.Refrigerante;
import com.api.rpfood.services.RefrigeranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bebidas")
@CrossOrigin(origins = "http://localhost:4200")
public class RefrigeranteController {

    private final RefrigeranteService refrigeranteService;

    @Autowired
    public RefrigeranteController(RefrigeranteService refrigeranteService) {
        this.refrigeranteService = refrigeranteService;
    }

    @GetMapping
    public ResponseEntity<List<Refrigerante>> getAllRefrigerantes() {
        List<Refrigerante> refrigerantes = refrigeranteService.getAllRefrigerantes();
        System.out.println("Chamada para getAllRefrigerantes. Número de refrigerantes: " + refrigerantes.size());
        return ResponseEntity.ok(refrigerantes);
    }



    @GetMapping("/{id}")
    public ResponseEntity<Refrigerante> getRefrigeranteById(@PathVariable Long id) {
        Optional<Refrigerante> refrigerante = refrigeranteService.getRefrigeranteById(id);
        return refrigerante.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping
    public Refrigerante saveRefrigerante(@RequestBody Refrigerante refrigerante) {
        return refrigeranteService.saveRefrigerante(refrigerante);
    }

    @DeleteMapping("/{id}")
    public void deleteRefrigerante(@PathVariable Long id) {
        refrigeranteService.deleteRefrigerante(id);
    }

}
