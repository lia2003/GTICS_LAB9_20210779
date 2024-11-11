package org.example.gtics_lab9_20210779.repository;

import org.example.gtics_lab9_20210779.entity.Cocktail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CocktailRepository extends JpaRepository<Cocktail, Long> {
}

