package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.actors.SpriteActor;

import static com.badlogic.gdx.Gdx.graphics;
import static com.badlogic.gdx.Gdx.input;
import static com.badlogic.gdx.Input.Keys;

@SuppressWarnings("SpellCheckingInspection")
class TitleScreen extends BaseScreen {
    private static final String UI_SKIN_FILE = "uiskin.json";
    private Label title;
    private SpriteActor spriteActor;

    private float movSpd = 10f;

    TitleScreen(ShmupGame game) {
        super(game);
        Skin uiSkin = game.assets.loadSync(UI_SKIN_FILE, Skin.class);
        assert uiSkin != null;
        this.title = new Label("Shmup4J yay press space to start", uiSkin);
        stage.addActor(title);

        title.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new GameScreen(game));
            }
        });

        spriteActor = new SpriteActor();
        spriteActor.setSprite(new Sprite(game.assets.loadSync("ship.png", Texture.class)));
        stage.addActor(spriteActor);
    }

    @Override
    public void act(float delta) {
        float speed = 50f;
        float newWidth = spriteActor.getWidth();
        float newHeight = spriteActor.getHeight();
        newHeight += (input.isKeyPressed(Keys.UP) ? speed : 0f) * delta;
        newHeight += (input.isKeyPressed(Keys.DOWN) ? -speed : 0f) * delta;
        newWidth += (input.isKeyPressed(Keys.RIGHT) ? speed : 0f) * delta;
        newWidth += (input.isKeyPressed(Keys.LEFT) ? -speed : 0f) * delta;

        float mouseX = input.getX();
        float mouseY = input.getY();
        Vector3 mousePos = stage.getCamera().unproject(new Vector3(mouseX, mouseY, 0));
        spriteActor.setBounds(mousePos.x, mousePos.y, newWidth, newHeight);

        float screenWidth = graphics.getWidth();
        float screenHeight = graphics.getHeight();
        title.setText("mouse pos: " + mousePos + "; screen dim: " + screenWidth + ", " + screenHeight);

        super.act(delta);
    }
}
