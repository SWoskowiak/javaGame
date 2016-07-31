package com.mygdx.game;

import com.badlogic.gdx.assets.AssetManager;

class Assets {
    AssetManager manager;

    Assets() {
        manager = new AssetManager();
    }

    <T> T loadSync(String filename, Class<T> type) {
        manager.load(filename, type);
        manager.finishLoadingAsset(filename);
        return manager.get(filename);
    }
}
