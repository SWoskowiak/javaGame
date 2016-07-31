package com.mygdx.game;

/**
 * Created by stefan on 7/30/16.
 */
public class GameScreen extends BaseScreen {

    public GameScreen(ShmupGame game) {
        super(game);

        Ship player = new Ship();

        stage.addActor(player);
    }
}
