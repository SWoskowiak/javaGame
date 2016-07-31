package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

import static com.badlogic.gdx.Gdx.app;
import static com.badlogic.gdx.Gdx.files;
import static com.badlogic.gdx.Gdx.input;
import static com.badlogic.gdx.Input.Keys;

public class TitleScreen extends BaseScreen {
    Skin uiSkin;
    Label title;

    float movSpd = 10f;

    class InputProcessor extends InputAdapter {
    }

    public TitleScreen(ShmupGame game) {
        super(game);
        uiSkin = new Skin(files.internal("uiskin.json"));
        this.title = new Label("Schmup4J", uiSkin);
        stage.addActor(title);
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }

    @Override
    protected void act(float delta) {
        float moveTitleX = 0f;
        float moveTitleY = 0f;

        if (input.isKeyPressed(Keys.A)) movSpd += 1f;
        if (input.isKeyPressed(Keys.Z)) movSpd -= 1f;

        if (input.isKeyPressed(Keys.DOWN)) moveTitleY -= delta * movSpd;
        if (input.isKeyPressed(Keys.UP)) moveTitleY += delta * movSpd;
        if (input.isKeyPressed(Keys.LEFT)) moveTitleX -= delta * movSpd;
        if (input.isKeyPressed(Keys.RIGHT)) moveTitleX += delta * movSpd;

        title.moveBy(moveTitleX, moveTitleY);

        boolean moved = moveTitleX != 0f || moveTitleY != 0f;

        if (moved) {

            app.log("TitleScreen.act", "movSpd " + movSpd + "; title position " + title.getX() + "x" + title.getY());
        }

        super.act(delta);
    }
}
