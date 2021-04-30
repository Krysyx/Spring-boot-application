package com.springtourofheroes.Repositories;

import com.springtourofheroes.Classes.CustomHero;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface CustomHeroRepository extends MongoRepository<CustomHero, String> {
    CustomHero save(CustomHero customHero);

    List<CustomHero> findAll();

    Optional<CustomHero> findById(String id);

    void deleteById(String id);
}
