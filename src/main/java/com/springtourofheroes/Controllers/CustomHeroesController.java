package com.springtourofheroes.Controllers;

import com.springtourofheroes.Classes.CustomHero;
import com.springtourofheroes.Services.CustomHeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/custom")
public class CustomHeroesController {
    @Autowired
    private CustomHeroService customHeroService;

    @GetMapping("")
    public List<CustomHero> getCustomHeroes() {
        return this.customHeroService.getCustomHeroes();
    }

    @PostMapping("/create")
    public CustomHero create(@Valid @RequestBody CustomHero customHero) {
        return this.customHeroService.createCustomHero(customHero);
    }
}
