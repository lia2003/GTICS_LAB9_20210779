package org.example.gtics_lab9_20210779.service;

import org.example.gtics_lab9_20210779.entity.Cocktail;
import org.example.gtics_lab9_20210779.repository.CocktailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CocktailService {

    private final RestTemplate restTemplate;

    @Autowired
    private CocktailRepository cocktailRepository;

    public CocktailService() {
        this.restTemplate = new RestTemplate();
    }

    public List<Map<String, String>> getCocktails() {
        String url = "https://www.thecocktaildb.com/api/json/v1/1/filter.php?c=Cocktail";
        ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class);

        List<Map<String, String>> drinks = (List<Map<String, String>>) response.getBody().get("drinks");
        List<Map<String, String>> limitedDrinks = drinks.subList(0, Math.min(drinks.size(), 12));

        // Guarda los cocteles en la base de datos y convierte a Map<String, String>
        limitedDrinks.forEach(drink -> {
            Cocktail cocktail = new Cocktail();
            cocktail.setName(drink.get("strDrink"));
            cocktail.setImageUrl(drink.get("strDrinkThumb"));
            cocktailRepository.save(cocktail);
        });

        return limitedDrinks;
    }
}
