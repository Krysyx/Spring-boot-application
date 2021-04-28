package com.springtourofheroes.Controllers;

import com.springtourofheroes.Classes.Hero;
import com.springtourofheroes.Services.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "/api/heroes")
public class HeroController {
    @Autowired
    HeroService heroService;

    @GetMapping("")
    public List<Hero> findAll() {
        return this.heroService.getHeroes();
    }

    @GetMapping("/{id}")
    public Optional<Hero> findById(@PathVariable String id) {
        return this.heroService.getHeroById(id);
    }

    @PutMapping("/update")
    public Hero update(@RequestBody Hero hero) {
        return this.heroService.updateHero(hero);
    }

    @PostMapping("/create")
    public Hero create(@RequestBody Hero hero) {
        return this.heroService.createHero(hero);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody
    void delete(@PathVariable String id) {
        this.heroService.deleteHero(id);
    }

    @GetMapping("/hero")
    public List<Optional<Hero>> findByName(@RequestParam String name) {
        return this.heroService.getHeroesByName(name);
    }
}

