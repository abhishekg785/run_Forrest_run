package com.mygdx.martianrun.actors;

import com.badlogic.gdx.physics.box2d.Body;
import com.mygdx.martianrun.box2d.GroundUserData;

/**
 * Created by hiro on 18/11/16.
 */
public class Ground extends GameActor{

    public Ground(Body body) {
        super(body);
    }

    public GroundUserData getUserData() {
        return (GroundUserData) userData;
    }
}
