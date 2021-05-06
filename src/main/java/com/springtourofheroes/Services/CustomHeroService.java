package com.springtourofheroes.Services;

import com.springtourofheroes.Classes.CustomHero;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CustomHeroService {
    abstract List<CustomHero> getCustomHeroes();

    abstract CustomHero createCustomHero(CustomHero customHero);

    abstract Optional<CustomHero> getCustomHero(String id);

    abstract void deleteCustomHero(String id);
}
