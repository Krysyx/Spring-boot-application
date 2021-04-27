package com.springtourofheroes.Classes;

import com.springtourofheroes.Models.Spells;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Document(collection = "custom")
public class CustomHero {
    @Id
    private String id;
    @NotNull
    private String name;
    @NotNull
    private Long HP;
    @NotNull
    private Long spellpower;
    private int mana;
    private Spells spells;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getHP() {
        return HP;
    }

    public void setHP(Long HP) {
        this.HP = HP;
    }

    public Long getSpellpower() {
        return spellpower;
    }

    public void setSpellpower(Long spellpower) {
        this.spellpower = spellpower;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(Integer mana) {
        this.mana = mana;
    }

    public Spells getSpells() {
        return spells;
    }

    public void setSpells(Spells spells) {
        this.spells = spells;
    }
}
