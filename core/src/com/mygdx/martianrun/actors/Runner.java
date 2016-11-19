package com.mygdx.martianrun.actors;

import com.badlogic.gdx.physics.box2d.Body;
import com.mygdx.martianrun.box2d.RunnerUserData;

/**
 * Created by hiro on 18/11/16.
 */
public class Runner extends GameActor {

    private boolean jumping;
    private boolean dodging;

    public Runner(Body body) {
        super(body);
    }

    public RunnerUserData getUserData() {
        return (RunnerUserData) userData;
    }

    public void jump() {
        if(!jumping) {
            body.applyLinearImpulse(getUserData().getJumpingLinearImpulse(), body.getWorldCenter(), true);
            jumping = true;
        }
    }

    public void dodge() {
        if(!jumping) {
            body.setTransform(getUserData().getDodgePosition(), getUserData().getDodgeAngle());
            dodging = true;
        }
    }

    public  boolean isDodging() {
        return dodging;
    }

    public void stopDodge() {
        dodging = false;
        body.setTransform(getUserData().getRunningPosition(),0f);
    }

    public void landed() {
        jumping = false;
    }
}
