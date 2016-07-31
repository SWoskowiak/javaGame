package com.mygdx.game;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;

import static com.badlogic.gdx.Gdx.files;

public class TitleScreen extends BaseScreen {
    Skin uiSkin;
    Label title;

    public TitleScreen(ShmupGame game) {
        super(game);
        uiSkin = new Skin(files.internal("uiskin.json"));
        this.title = new Label("Schmup4J", uiSkin);
        stage.addActor(title);
    }
}
