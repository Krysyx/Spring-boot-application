package com.springtourofheroes.Controllers;

import com.springtourofheroes.Classes.CustomHero;
import com.springtourofheroes.Services.CustomHeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/custom")
public class CustomHeroesController {
    @Autowired
    private CustomHeroService customHeroService;

    @GetMapping("")
    public List<CustomHero> getCustomHeroes() {
        return this.customHeroService.getCustomHeroes();
    }

    @GetMapping("/{id}")
    public Optional<CustomHero> getCustomHero(@PathVariable String id) {
        return this.customHeroService.getCustomHero(id);
    }

    @PostMapping("/create")
    public CustomHero create(@Valid @RequestBody CustomHero customHero) {
        return this.customHeroService.createCustomHero(customHero);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        this.customHeroService.deleteCustomHero(id);
    }
}
