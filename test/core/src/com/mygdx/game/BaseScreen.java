package com.mygdx.game;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;

import static com.badlogic.gdx.Gdx.gl20;
import static com.badlogic.gdx.Gdx.input;


class BaseScreen extends ScreenAdapter {
    Stage stage;
    ShmupGame game;

    BaseScreen(ShmupGame game) {
        this.game = game;
        this.stage = new Stage();
        input.setInputProcessor(this.stage);
    }

    @Override
    public void render(float delta) {
        act(delta);
        draw(delta);
    }

    public void act(float delta) {
        stage.act(delta);
    }

    @SuppressWarnings("WeakerAccess")
    void draw(float delta) {
        gl20.glClearColor(0, 0, 0, 1);
        gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.draw();
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
