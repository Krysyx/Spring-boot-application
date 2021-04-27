package com.springtourofheroes.Controllers;

import com.springtourofheroes.Classes.CustomHero;
import com.springtourofheroes.Services.CustomHeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/custom")
public class CustomHeroesController {
    @Autowired
    private CustomHeroService customHeroService;

    @PostMapping("/create")
    public CustomHero create(@Valid @RequestBody CustomHero customHero) {
        return this.customHeroService.createCustomHero(customHero);
    }
}
