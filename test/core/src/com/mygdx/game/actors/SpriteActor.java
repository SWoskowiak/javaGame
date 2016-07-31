package com.mygdx.game.actors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.components.Component;
import com.mygdx.game.components.Destructible;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.badlogic.gdx.math.MathUtils.isEqual;

public class SpriteActor extends Actor {
    private Sprite sprite;
    private boolean dirty;

    public void setSprite(Sprite sprite) {
        if (isEqual(this.getWidth(), 0) && isEqual(this.getHeight(), 0)) {
            setSize(sprite.getWidth(), sprite.getHeight());
        } else {
            sprite.setBounds(getX(), getY(), getWidth(), getHeight());
        }
        sprite.setRotation(getRotation());
        sprite.setScale(getScaleX(), getScaleY());
        this.sprite = sprite;
    }

    @Override
    protected void positionChanged() {
        if (sprite != null) sprite.setPosition(getX(), getY());
    }

    @Override
    protected void sizeChanged() {
        if (sprite != null) sprite.setSize(getWidth(), getHeight());
    }

    @Override
    protected void rotationChanged() {
        if (sprite != null) sprite.setRotation(getRotation());
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        if (sprite != null) {
            sprite.draw(batch, parentAlpha);
        }
    }
}
