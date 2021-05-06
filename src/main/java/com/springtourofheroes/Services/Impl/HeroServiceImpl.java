package com.springtourofheroes.Services.Impl;

import com.springtourofheroes.Classes.Hero;
import com.springtourofheroes.Repositories.HeroRepository;
import com.springtourofheroes.Services.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class HeroServiceImpl implements HeroService {
    @Autowired
    private HeroRepository heroRepository;

    @Override
    public List<Hero> getHeroes() {
        return this.heroRepository.findAll();
    }

    @Override
    public Optional<Hero> getHeroById(String id) {
        return this.heroRepository.findById(id);
    }

    @Override
    public Hero updateHero(Hero hero) {
        return this.heroRepository.save(hero);
    }

    @Override
    public Hero createHero(Hero hero) {
        return this.heroRepository.save(hero);
    }

    @Override
    public void deleteHero(String id) {
        this.heroRepository.deleteById(id);
    }

    @Override
    public Optional<Hero> getHeroByName(String name) {
        return this.heroRepository.findByName(name);
    }

    @Override
    public List<Optional<Hero>> getHeroesByName(String name) {
        return this.heroRepository.findAllByName(name);
    }
}
