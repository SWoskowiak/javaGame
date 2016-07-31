package com.mygdx.game.components;

import com.badlogic.gdx.utils.Pool;

public class Component implements Pool.Poolable {
    public Entity entity;

    public void reset() {
        entity = null;
    }
}
