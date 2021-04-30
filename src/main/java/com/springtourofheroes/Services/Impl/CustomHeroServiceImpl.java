package com.springtourofheroes.Services.Impl;

import com.springtourofheroes.Classes.CustomHero;
import com.springtourofheroes.Repositories.CustomHeroRepository;
import com.springtourofheroes.Services.CustomHeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomHeroServiceImpl implements CustomHeroService {
    @Autowired
    private CustomHeroRepository customHeroRepository;

    @Override
    public CustomHero createCustomHero(CustomHero customHero) {
        return this.customHeroRepository.save(customHero);
    }

    @Override
    public List<CustomHero> getCustomHeroes() {
        return this.customHeroRepository.findAll();
    }

    @Override
    public Optional<CustomHero> getCustomHero(String id) {
        return this.customHeroRepository.findById(id);
    }

    @Override
    public void deleteCustomHero(String id) {
        this.customHeroRepository.deleteById(id);
    }
}
