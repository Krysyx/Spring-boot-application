package com.springtourofheroes.Repositories;

import com.springtourofheroes.Classes.CustomHero;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomHeroRepository extends MongoRepository<CustomHero, String> {
    CustomHero save(CustomHero customHero);

    List<CustomHero> findAll();

    Optional<CustomHero> findById(String id);

    void deleteById(String id);
}
