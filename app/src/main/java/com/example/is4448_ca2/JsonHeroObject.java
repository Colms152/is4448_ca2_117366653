package com.example.is4448_ca2;

import java.util.ArrayList;


public class JsonHeroObject {
    private String error;
    private String message;
    private ArrayList<HeroObject> heroes;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public ArrayList<HeroObject> getHeroes() {
        return heroes;
    }

    public void setHeroes(ArrayList<HeroObject> heroes) {
        this.heroes = heroes;
    }
}
