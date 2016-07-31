package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

/**
 * Created by stefan on 7/30/16.
 */
public class Ship extends Actor{
    // Our ship texture
    private Texture img;

    public void Ship() {
        // Our ship's texture
        img = new Texture("ship.png");

        // The bounds of the ship
        this.setBounds(0, 0, img.getWidth(), img.getHeight());
    }

    @Override
    public void act(float Delta) {
        if(Gdx.input.isKeyPressed(Input.Keys.A)) {
           this.setX(this.getX() - (5 * Delta));
           System.out.println("x: " + this.getX());
        }
    }
}
