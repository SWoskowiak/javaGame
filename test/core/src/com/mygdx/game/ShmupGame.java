package com.mygdx.game;

import com.badlogic.gdx.Game;

/*
GRINDIUS

Easy baddo grind level (scrap metal, common alien parts)
Challenge level with strong baddos (drop rare alien parts) OR obstacle dodging (direct cash pickups)
Easy baddo grind level
Challenge level with strong baddos (drop rare alien parts) OR obstacle dodging (direct cash pickups)
Boss level

repeat ad nauseum

You are collecting:

scrap metal
cash
discarded alien weaponry (powerups, they have durability)

the idea is that you get easy things from the easy grind levels, it's like shooting fish in a barrel
then the cha

 */

public class ShmupGame extends Game {
    Assets assets;

    @Override
    public void create() {
        assets = new Assets();
        TitleScreen ts = new TitleScreen(this);
        setScreen(ts);
    }

    @Override
    public void render() {
        if (assets.manager.update()) {
            super.render();
        }
    }

    @Override
    public void dispose() {
        super.dispose();


    }
}
