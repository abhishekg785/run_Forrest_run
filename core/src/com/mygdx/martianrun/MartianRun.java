package com.mygdx.martianrun;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.martianrun.screens.GameScreen;
import com.mygdx.martianrun.screens.MainMenuScreen;

public class MartianRun extends Game {

	public SpriteBatch batch;    // Draw batched quads using indices
	public BitmapFont font;

	@Override
	public void create () {
		batch = new SpriteBatch();
		font = new BitmapFont();
		setScreen(new MainMenuScreen( this ));
	}

	public void render() {
		super.render();
	}

	public void dispose() {
		batch.dispose();
		font.dispose();
	}

}
