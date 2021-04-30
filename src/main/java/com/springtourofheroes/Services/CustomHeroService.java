package com.springtourofheroes.Services;

import com.springtourofheroes.Classes.CustomHero;

import java.util.List;
import java.util.Optional;

public interface CustomHeroService {
    abstract List<CustomHero> getCustomHeroes();

    abstract CustomHero createCustomHero(CustomHero customHero);

    abstract Optional<CustomHero> getCustomHero(String id);
}
