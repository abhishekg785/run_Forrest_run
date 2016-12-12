package com.mygdx.martianrun.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.martianrun.MartianRun;
import com.mygdx.martianrun.utils.Constants;

/**
 * Created by hiro on 12/12/16.
 */
public class MainMenuScreen implements Screen {

    OrthographicCamera camera;

    final MartianRun game;

    private static final int VIEWPORT_WIDTH = Constants.APP_WIDTH;
    private static final int VIEWPORT_HEIGHT = Constants.APP_HEIGHT;

    public MainMenuScreen(final MartianRun gam) {

        game = gam;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, VIEWPORT_WIDTH, VIEWPORT_HEIGHT);

    }
    @Override
    public void render(float delta) {
        System.out.println("in the render function of the MainMenuScreen ");
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.font.draw(game.batch, "Welcome to the 'Run Forrest Run' ", 100, 150);
        game.font.draw(game.batch, "Tap anywhere to begin!", 100, 120);
        game.font.draw(game.batch, "Created by Abhishek Goswami", 600, 30);
        game.batch.end();

        if(Gdx.input.isTouched()) {
            game.setScreen(new GameScreen());
        }
    }

    @Override
    public void show() {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
