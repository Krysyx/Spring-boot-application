package com.springtourofheroes.Services;

import com.springtourofheroes.Classes.CustomHero;

import java.util.List;

public interface CustomHeroService {
    abstract List<CustomHero> getCustomHeroes();

    abstract CustomHero createCustomHero(CustomHero customHero);
}
