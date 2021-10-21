package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

// import com.mygdx.game.screens.*;

public class MyGdxGame extends ApplicationAdapter {

  private ShapeRenderer shapeRenderer;

  private float circleX = 200;
  private float circleY = 100;

  private float rectX = 50;
  private float rectY = 400;

  private float circleR = 40;
  private float rectW = 80;
  private float rectH = 80;

  private float xSpeed = 240;
  private float ySpeed = 180;

  private int gameWidth;
  private int gameHeight;

  private float deltaTime;

  @Override
  public void create() {
    shapeRenderer = new ShapeRenderer();
  }

  @Override
  public void render() {
    super.render();

    gameWidth = Gdx.graphics.getWidth();
    gameHeight = Gdx.graphics.getHeight();

    deltaTime = Gdx.graphics.getDeltaTime();

    circleX += xSpeed * deltaTime;
    circleY += ySpeed * deltaTime;

    if (circleX - circleR <= 0 || circleX + circleR >= gameWidth) {
      xSpeed *= -1;
    }

    if (circleY - circleR <= 0 || circleY + circleR >= gameHeight) {
      ySpeed *= -1;
    }

    if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
      circleY += ySpeed * 2 * deltaTime;
      if (circleY + circleR >= gameHeight) {
        circleY += -ySpeed * 2 * deltaTime;
      }
    }

    System.out.println();

    if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
      rectY += 400 * deltaTime;
      if (rectY + rectH >= gameHeight) {
        rectY += -400 * deltaTime;
      }
    }

    if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
      rectY += -400 * deltaTime;
      if (rectY <= 0) {
        rectY += +400 * deltaTime;
      }
    }

    if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
      rectX += -400 * deltaTime;
      if (rectX <= 0) {
        rectX += +400 * deltaTime;
      }
    }

    if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
      rectX += +400 * deltaTime;
      if (rectX + rectW >= gameWidth) {
        rectX += -400 * deltaTime;
      }
    }

    float rectTop = rectY + rectH;
    float rectTopMid = (rectX + rectW + rectX) / 2;

    if (
      (rectTop <= circleY + circleR && rectTop >= circleY - circleR) &&
      (rectTopMid <= circleX + circleR && rectTopMid >= circleX - circleR)
    ) {
      circleY += circleY / 2 * deltaTime;
      rectY -= rectY * deltaTime;

      if (circleY + circleR >= gameHeight) {
        circleY += -1000 * deltaTime;
      }
      if (rectY <= 0) {
        rectY += +rectY * deltaTime;
      }
      if (ySpeed < 0) {
        ySpeed *= -1;
      }
    }

    Gdx.gl.glClearColor(.25f, .25f, .25f, 1);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

    shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
    shapeRenderer.setColor(52, 31, 0, 1);
    shapeRenderer.circle(circleX, circleY, circleR);
    shapeRenderer.setColor(200, 10, 90, 1);
    shapeRenderer.rect(rectX, rectY, rectW, rectH);
    shapeRenderer.end();
  }

  @Override
  public void resize(int width, int height) {
    super.resize(width, height);
  }

  @Override
  public void pause() {
    super.pause();
  }

  @Override
  public void resume() {
    super.resume();
  }

  @Override
  public void dispose() {
    super.dispose();

    shapeRenderer.dispose();
  }
}
