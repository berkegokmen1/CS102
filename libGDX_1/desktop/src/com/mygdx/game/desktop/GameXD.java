package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.MyGdxGame;

public class GameXD {

  public static void main(String[] arg) {
    LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
    config.title = "...";
    config.width = 1366;
    config.height = 768;
    config.resizable = false;
    config.fullscreen = false;
    new LwjglApplication(new MyGdxGame(), config);
  }
}
