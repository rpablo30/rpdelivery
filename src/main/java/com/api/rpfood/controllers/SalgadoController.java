package com.api.rpfood.controllers;


import com.api.rpfood.models.Salgado;
import com.api.rpfood.services.SalgadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/salgados")
@CrossOrigin(origins = "http://localhost:4200")
public class SalgadoController {

    private final SalgadoService salgadoService;

    @Autowired
    public SalgadoController(SalgadoService salgadoService) {
        this.salgadoService = salgadoService;
    }

    @GetMapping
    public ResponseEntity<List<Salgado>> obterSalgados() {
        List<Salgado> salgados = salgadoService.obterSalgados();
        // Adicione logs para verificar
        System.out.println("Chamada para obterSalgados. Número de salgados: " + salgados.size());
        return ResponseEntity.ok(salgados);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Salgado> obterSalgadoPorId(@PathVariable Long id) {
        Optional<Salgado> salgado = salgadoService.obterSalgadoPorId(id);
        return salgado.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Salgado salvarSalgado(@RequestBody Salgado salgado) {
        return salgadoService.salvarSalgado(salgado);
    }

    @DeleteMapping("/{id}")
    public void deletarSalgado(@PathVariable Long id) {
        salgadoService.deletarSalgado(id);
    }
}
