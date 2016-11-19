package com.mygdx.martianrun.utils;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by hiro on 18/11/16.
 */
public class Constants {

    // set the height and the width of the game screen
    public static final int APP_WIDTH = 800;
    public static final int APP_HEIGHT = 480;

    // world is created using the gravity of -10 m/s^2 ( using real life parameters  :P )
    public static final Vector2 WORLD_GRAVITY = new Vector2(0, -10);

    // parameters for creating a Ground
    public static final float GROUND_X = 0;
    public static final float GROUND_Y = 0;
    public static final float GROUD_WIDTH = 25f;
    public static final float GROUND_HEIGHT = 2f;
    public static final float GROUND_DENSITY = 0f;

    // parameters for the runner in the game
    // a box that is 1m wide and 2m high
    public static final float RUNNER_X = 2;
    public static final float RUNNER_Y = GROUND_Y + GROUND_HEIGHT;
    public static final float RUNNER_WIDTH = 1f;
    public static final float RUNNER_HEIGHT = 2f;
    public static float RUNNER_DENSITY = 0.5f;

    // next step is to make the player dodge
    // if the runner is not jumping and we touch the left side of the screen
    // he will be sliding till the end
    // by sliding we mean rotation by -90deg and placing it above just above ground
    public static final float RUNNER_DODGE_X = 2f;
    public static final float RUNNER_DODGE_Y = 1.5f;

    public static final float RUNNER_GRAVITY_SCALE = 3f;
    public static final Vector2 RUNNER_JUMPING_LINEAR_IMPULSE = new Vector2(0, 13f);
}
