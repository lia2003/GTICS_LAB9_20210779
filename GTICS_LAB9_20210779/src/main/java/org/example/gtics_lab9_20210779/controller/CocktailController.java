package org.example.gtics_lab9_20210779.controller;

import org.example.gtics_lab9_20210779.entity.Favorite;
import org.example.gtics_lab9_20210779.service.CocktailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/detail/{id}")
    public ResponseEntity<Map<String, Object>> getCocktailDetail(@PathVariable String id) {
        Map<String, Object> cocktailDetail = cocktailService.getCocktailDetail(id);
        return ResponseEntity.ok(cocktailDetail);
    }

    @PostMapping("/favorite")
    public ResponseEntity<Favorite> addFavorite(@RequestBody Favorite favorite) {
        Favorite savedFavorite = cocktailService.addFavorite(favorite);
        return ResponseEntity.ok(savedFavorite);
    }

    @GetMapping("/favorites")
    public ResponseEntity<List<Favorite>> getFavorites() {
        List<Favorite> favorites = cocktailService.getFavorites();
        return ResponseEntity.ok(favorites);
    }
}
