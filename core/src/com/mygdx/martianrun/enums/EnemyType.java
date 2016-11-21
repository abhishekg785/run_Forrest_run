package com.mygdx.martianrun.enums;

import com.mygdx.martianrun.utils.Constants;

/**
 * Created by hiro on 19/11/16.
 *
 *  there will be 6 types of enemies
 *  coming towards our runner
 *
 *  Render an animation
 *  Each enemy has its own animation
 *  Running small - lady bug
 *  Running Wide = worm
 *  Running long = barnacle
 *  Running big = spider
 *  Flying small = bee
 *  Flying wide - fly
 */

public enum EnemyType {

    RUNNING_SMALL(1f, 1f, Constants.ENEMY_X, Constants.RUNNING_SHORT_ENEMY_Y, Constants.ENEMY_DENSITY, Constants.RUNNING_SMALL_ENEMY_REGION_NAMES),
    RUNNING_WIDE(1f, 1f, Constants.ENEMY_X, Constants.RUNNING_SHORT_ENEMY_Y, Constants.ENEMY_DENSITY, Constants.RUNNING_WIDE_ENEMY_REGION_NAMES),
    RUNNING_LONG(1f, 1f, Constants.ENEMY_X, Constants.RUNNING_LONG_ENEMY_Y, Constants.ENEMY_DENSITY, Constants.RUNNING_LONG_ENEMY_REGION_NAMES),
    RUNNING_BIG(1f, 1f, Constants.ENEMY_X, Constants.RUNNING_LONG_ENEMY_Y, Constants.ENEMY_DENSITY, Constants.RUNNING_BIG_ENEMY_REGION_NAMES),
    FLYING_SMALL(1f, 1f, Constants.ENEMY_X, Constants.FLYING_ENEMY_Y, Constants.ENEMY_DENSITY, Constants.FLYING_SMALL_ENEMY_REGIONS),
    FLYING_WIDE(1f, 1f, Constants.ENEMY_X, Constants.FLYING_ENEMY_Y, Constants.ENEMY_DENSITY, Constants.FLYING_WIDE_ENEMY_REGION_NAMES);

    private float width;
    private float height;
    private float x;
    private float y;
    private float density;
    private String[] regions;

    EnemyType(float width, float height, float x, float y, float density, String[] regions) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.density = density;
        this.regions = regions;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return  y;
    }

    public float getDensity() {
        return  density;
    }

    public String[] getRegions() {
        return regions;
    }

}
