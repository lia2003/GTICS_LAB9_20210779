package org.example.gtics_lab9_20210779.controller;

import org.example.gtics_lab9_20210779.service.CocktailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cocktails")
public class CocktailController {

    @Autowired
    private CocktailService cocktailService;

    @GetMapping("/list")
    public ResponseEntity<List<Map<String, String>>> getCocktails() {
        List<Map<String, String>> cocktails = cocktailService.getCocktails();
        return ResponseEntity.ok(cocktails);
    }
}
