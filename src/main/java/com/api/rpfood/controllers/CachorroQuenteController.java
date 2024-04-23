package com.api.rpfood.controllers;

import com.api.rpfood.models.CachorroQuente;
import com.api.rpfood.services.CachorroQuenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cachorroquente")
@CrossOrigin(origins = "http://localhost:4200")
public class CachorroQuenteController {

    private final CachorroQuenteService cachorroQuenteService;

    @Autowired
    public CachorroQuenteController(CachorroQuenteService cachorroQuenteService) {
        this.cachorroQuenteService = cachorroQuenteService;
    }

    @GetMapping
    public List<CachorroQuente> obterTodosCachorrosQuentes() {
        return cachorroQuenteService.obterTodosCachorrosQuentes();
    }

}
