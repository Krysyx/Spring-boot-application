package com.springtourofheroes.Services.Impl;

import com.springtourofheroes.Classes.CustomHero;
import com.springtourofheroes.Repositories.CustomHeroRepository;
import com.springtourofheroes.Services.CustomHeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomHeroServiceImpl implements CustomHeroService {
    @Autowired
    private CustomHeroRepository customHeroRepository;

    public CustomHero createCustomHero(CustomHero customHero) {
        return this.customHeroRepository.save(customHero);
    }
}
