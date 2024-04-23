package com.api.rpfood.controllers;

import com.api.rpfood.models.Pudim;
import com.api.rpfood.services.PudimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pudim")
@CrossOrigin(origins = "http://localhost:4200")
public class PudimController {

    private final PudimService pudimService;

    @Autowired
    public PudimController(PudimService pudimService) {
        this.pudimService = pudimService;
    }

    @GetMapping
    public ResponseEntity<List<Pudim>> obterPudins() {
        List<Pudim> pudins = pudimService.obterPudins();
        System.out.println("Chamada para obterPudins. Número de pudins: " + pudins.size());
        return ResponseEntity.ok(pudins);
    }
}
