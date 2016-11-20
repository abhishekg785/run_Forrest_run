package com.mygdx.martianrun.actors;

import com.badlogic.gdx.physics.box2d.Body;
import com.mygdx.martianrun.box2d.RunnerUserData;

/**
 * Created by hiro on 18/11/16.
 */
public class Runner extends GameActor {

    private boolean jumping;
    private boolean dodging;
    private boolean hit;

    public Runner(Body body) {
        super(body);
    }

    public RunnerUserData getUserData() {
        return (RunnerUserData) userData;
    }

    public void jump() {
        System.out.println("In the jump function");
        if(!(jumping || dodging || hit)) {
            body.applyLinearImpulse(getUserData().getJumpingLinearImpulse(), body.getWorldCenter(), true);
            jumping = true;
        }
    }

    public void dodge() {
        System.out.println("In the dodge function");
        if(!(jumping || hit)) {
            body.setTransform(getUserData().getDodgePosition(), getUserData().getDodgeAngle());
            dodging = true;
        }
    }

    public  boolean isDodging() {
        return dodging;
    }

    public void stopDodge() {
        dodging = false;
        // if the runner is hit, don't force him to get back to the running position
        if(!hit){
            body.setTransform(getUserData().getRunningPosition(),0f);
        }
    }

    public void hit() {
        System.out.println("hit function called");
        body.applyAngularImpulse(getUserData().getHitAngularImpulse(), true);
        hit = true;
    }

    public boolean isHit() {
        return hit;
    }

    public void landed() {
        jumping = false;
    }
}
