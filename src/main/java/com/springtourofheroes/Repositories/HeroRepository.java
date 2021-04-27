package com.springtourofheroes.Repositories;

import com.springtourofheroes.Classes.Hero;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface HeroRepository extends MongoRepository<Hero, String> {
    List<Hero> findAll();

    Optional<Hero> findById(String id);

    Hero save(Hero hero);

    void deleteById(String id);

    Optional<Hero> findByName(String name);

    List<Optional<Hero>> findAllByName(String name);
}