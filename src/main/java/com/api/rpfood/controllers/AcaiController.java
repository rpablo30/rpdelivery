package com.api.rpfood.controllers;

import com.api.rpfood.models.Acai;
import com.api.rpfood.services.AcaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/acai")
@CrossOrigin(origins = "http://localhost:4200")
public class AcaiController {

    private final AcaiService acaiService;

    @Autowired
    public AcaiController(AcaiService acaiService) {
        this.acaiService = acaiService;
    }

    @GetMapping
    public ResponseEntity<List<Acai>> getAllAcais() {
        List<Acai> acais = acaiService.getAllAcais();
        System.out.println("Chamada para getAllAcais. Número de acais: " + acais.size());
        return ResponseEntity.ok(acais);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Acai> getAcaiById(@PathVariable Long id) {
        Optional<Acai> acai = acaiService.getAcaiById(id);
        return acai.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Acai saveAcai(@RequestBody Acai acai) {
        return acaiService.saveAcai(acai);
    }

    @DeleteMapping("/{id}")
    public void deleteAcai(@PathVariable Long id) {
        acaiService.deleteAcai(id);
    }
}
