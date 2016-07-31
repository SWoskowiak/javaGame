package com.mygdx.game;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.ReflectionPool;

import static com.badlogic.gdx.Gdx.app;
import static com.badlogic.gdx.Gdx.input;
import static com.badlogic.gdx.Input.Keys;

@SuppressWarnings("SpellCheckingInspection")
class TitleScreen extends BaseScreen {
    private static final String UI_SKIN_FILE = "uiskin.json";
    private Label title;

    private float movSpd = 10f;

    TitleScreen(ShmupGame game) {
        super(game);
        Skin uiSkin = game.assets.loadSync(UI_SKIN_FILE, Skin.class);
        assert uiSkin != null;
        this.title = new Label("Shmup4J yay press space to start", uiSkin);
        stage.addActor(title);
        ReflectionPool<Ship> rps;
    }

    @Override
    public void act(float delta) {
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

        if (input.isKeyJustPressed(Keys.SPACE)) game.setScreen(new GameScreen(game));

        super.act(delta);
    }
}
