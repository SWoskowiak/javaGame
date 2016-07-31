package com.mygdx.game;

import com.badlogic.gdx.Game;

/**
 * Created by michaelbartnett on 7/30/16.
 */
public class ShmupGame extends Game {


    @Override
    public void create() {
        setScreen(new TitleScreen(this));
    }
}
