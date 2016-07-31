package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

import static com.badlogic.gdx.Gdx.input;

/**
 * Created by stefan on 7/30/16.
 */
public class Ship extends Actor{
    // Our ship texture
    private Texture img;
    private float speed = 250;

    public Ship() {
        // Our ship's texture
        img = new Texture("ship.png");

        // The bounds of the ship
        this.setBounds(0, 0, img.getWidth(), img.getHeight());
    }

    private void checkMovement(float Delta) {
        // Move Left
        if(input.isKeyPressed(Input.Keys.A) || input.isKeyPressed(Input.Keys.LEFT)) {
            this.setX(this.getX() - (speed * Delta));
        }
        // Move Right
        if (input.isKeyPressed(Input.Keys.D) || input.isKeyPressed(Input.Keys.RIGHT)) {
            this.setX(this.getX() + (speed * Delta));
        }
        // Move Up
        if (input.isKeyPressed(Input.Keys.W) || input.isKeyPressed(Input.Keys.UP)) {
            this.setY(this.getY() + (speed * Delta));
        }
        // Move Down
        if (input.isKeyPressed(Input.Keys.S) || input.isKeyPressed(Input.Keys.DOWN)) {
            this.setY(this.getY() - (speed * Delta));
        }
    }

    private void checkFiring(float Delta) {
        if (input.isKeyPressed(Input.Keys.SPACE)) {
            this.setY(this.getY() - (speed * Delta));
        }
    }

    @Override
    public void act(float Delta) {
        checkMovement(Delta);
        checkFiring(Delta);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(img, this.getX(), this.getY());
    }
}
