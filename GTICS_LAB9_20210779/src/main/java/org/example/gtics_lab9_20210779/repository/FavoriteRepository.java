package org.example.gtics_lab9_20210779.repository;

import org.example.gtics_lab9_20210779.entity.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
}
