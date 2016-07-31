package com.mygdx.game;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;

import static com.badlogic.gdx.Gdx.gl20;


public class BaseScreen extends ScreenAdapter {
    protected Stage stage;
    protected ShmupGame game;

    public BaseScreen(ShmupGame game) {
        this.game = game;
        this.stage = new Stage();
    }

    @Override
    public void render(float delta) {
        gl20.glClearColor(0, 0, 0, 1);
        gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
