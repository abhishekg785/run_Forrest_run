package com.mygdx.martianrun.utils;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.martianrun.box2d.GroundUserData;
import com.mygdx.martianrun.box2d.RunnerUserData;

/**
 * Created by hiro on 18/11/16.
 *
 * takes care of creating the bodies in the game
 * our bodies will be created as follows :
 * Ground : Static body
 * Runner : Dynamic body
 * Enemies : Kinematic body
 */

public class WorldUtils {

    // creating a new world
    public static World createWorld() {
        return new World(Constants.WORLD_GRAVITY, true);
    }

    // creating the ground
    public static Body createGround(World world) {
        BodyDef bodyDef = new BodyDef();
        bodyDef.position.set(new Vector2(Constants.GROUND_X, Constants.GROUND_Y));
        Body body = world.createBody(bodyDef);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(Constants.GROUD_WIDTH / 2 , Constants.GROUND_HEIGHT / 2);
        body.createFixture(shape, Constants.GROUND_DENSITY);
        body.setUserData(new GroundUserData());
        shape.dispose();
        return  body;
    }

    // creating the runner in the game
    public static Body createRunner(World world) {
        BodyDef bodydef = new BodyDef();
        bodydef.type = BodyDef.BodyType.DynamicBody;
        bodydef.position.set(new Vector2(Constants.RUNNER_X, Constants.RUNNER_Y));
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(Constants.RUNNER_WIDTH / 2, Constants.RUNNER_HEIGHT / 2);
        Body body = world.createBody(bodydef);
        body.setGravityScale(Constants.RUNNER_GRAVITY_SCALE);
        body.createFixture(shape, Constants.RUNNER_DENSITY);
        body.resetMassData();
        body.setUserData(new RunnerUserData());
        shape.dispose();
        return body;
    }
}
