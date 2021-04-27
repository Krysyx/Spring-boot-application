package com.springtourofheroes.Services;

import com.springtourofheroes.Classes.Hero;

import java.util.List;
import java.util.Optional;

public interface HeroService {
    List<Hero> getHeroes();

    Optional<Hero> getHeroById(String id);

    Hero updateHero(Hero hero);

    Hero createHero(Hero hero);

    void deleteHero(String id);

    Optional<Hero> getHeroByName(String name);

    List<Optional<Hero>> getHeroesByName(String name);
}
