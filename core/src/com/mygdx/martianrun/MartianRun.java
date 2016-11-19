package com.mygdx.martianrun;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.martianrun.screens.GameScreen;

public class MartianRun extends Game {
	
	@Override
	public void create () {
		setScreen(new GameScreen());
	}

}
