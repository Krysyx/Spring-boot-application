package com.springtourofheroes.Classes;

import com.springtourofheroes.Models.Spells;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Document(collection = "custom")
public class CustomHero {
    @Id
    private String id;
    @NotNull
    @Indexed(unique = true)
    private String name;
    @NotNull
    private int hp;
    @NotNull
    private int spellpower;
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

    public int getMana() {
        return mana;
    }

    public void setMana(Integer mana) {
        this.mana = mana;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getSpellpower() {
        return spellpower;
    }

    public void setSpellpower(int spellpower) {
        this.spellpower = spellpower;
    }

    public Spells getSpells() {
        return spells;
    }

    public void setSpells(Spells spells) {
        this.spells = spells;
    }
}
