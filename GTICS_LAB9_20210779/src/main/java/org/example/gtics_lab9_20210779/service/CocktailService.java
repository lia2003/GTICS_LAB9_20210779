package org.example.gtics_lab9_20210779.service;

import org.example.gtics_lab9_20210779.entity.Favorite;
import org.example.gtics_lab9_20210779.repository.FavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class CocktailService {

    private final RestTemplate restTemplate;

    @Autowired
    private FavoriteRepository favoriteRepository;

    public CocktailService() {
        this.restTemplate = new RestTemplate();
    }

    public List<Map<String, String>> getCocktails() {
        String url = "https://www.thecocktaildb.com/api/json/v1/1/filter.php?c=Cocktail";
        ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class);

        if (response.getBody() == null || response.getBody().get("drinks") == null) {
            throw new RuntimeException("No se pudo obtener la lista de cocteles.");
        }

        List<Map<String, String>> drinks = (List<Map<String, String>>) response.getBody().get("drinks");
        List<Map<String, String>> limitedDrinks = drinks.subList(0, Math.min(drinks.size(), 12));
        return limitedDrinks;
    }

    public Map<String, Object> getCocktailDetail(String id) {
        String url = "https://www.thecocktaildb.com/api/json/v1/1/lookup.php?i=" + id;
        ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class);

        if (response.getBody() == null || response.getBody().get("drinks") == null) {
            throw new RuntimeException("No se pudo obtener el detalle del coctel.");
        }

        return (Map<String, Object>) response.getBody().get("drinks");
    }

    public Favorite addFavorite(Favorite favorite) {
        return favoriteRepository.save(favorite);
    }

    public List<Favorite> getFavorites() {
        return favoriteRepository.findAll();
    }
}
