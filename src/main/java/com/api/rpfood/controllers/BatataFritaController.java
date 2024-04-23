package com.api.rpfood.controllers;

import com.api.rpfood.models.Batatafrita;
import com.api.rpfood.services.BatataFritaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/batatasfritas")
@CrossOrigin(origins = "http://localhost:4200")
public class BatataFritaController {

    private final BatataFritaService batataFritaService;

    @Autowired
    public BatataFritaController(BatataFritaService batataFritaService) {
        this.batataFritaService = batataFritaService;
    }

    @GetMapping
    public ResponseEntity<List<Batatafrita>> obterBatatasFritas() {
        List<Batatafrita> batatasFritas = batataFritaService.obterBatatasFritas();
        // Adicione logs para verificar
        System.out.println("Chamada para obterBatatasFritas. Número de batatas fritas: " + batatasFritas.size());
        return ResponseEntity.ok(batatasFritas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Batatafrita> obterBatataFritaPorId(@PathVariable Long id) {
        Optional<Batatafrita> batataFrita = batataFritaService.obterBatataFritaPorId(id);
        return batataFrita.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Batatafrita salvarBatataFrita(@RequestBody Batatafrita batataFrita) {
        return batataFritaService.salvarBatataFrita(batataFrita);
    }

    @DeleteMapping("/{id}")
    public void deletarBatataFrita(@PathVariable Long id) {
        batataFritaService.deletarBatataFrita(id);
    }
}
