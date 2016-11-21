package com.mygdx.martianrun.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;
import com.mygdx.martianrun.box2d.RunnerUserData;
import com.mygdx.martianrun.utils.Constants;

import javax.xml.soap.Text;

/**
 * Created by hiro on 18/11/16.
 */
public class Runner extends GameActor {

    private boolean jumping;
    private boolean dodging;
    private boolean hit;
    private Animation runningAnimation;
    private TextureRegion jumpingTexture;
    private TextureRegion dodgingTexture;
    private TextureRegion hitTexture;
    private float stateTime;

    public Runner(Body body) {

        super(body);
        TextureAtlas textureAtlas = new TextureAtlas(Constants.CHARACTERS_ATLAS_PATH);
        TextureRegion[] runningFrames = new TextureRegion[Constants.RUNNER_RUNNING_REGION_NAMES.length];
        for(int i = 0 ; i < Constants.RUNNER_RUNNING_REGION_NAMES.length; i++) {
            String path = Constants.RUNNER_RUNNING_REGION_NAMES[i];
            runningFrames[i] = textureAtlas.findRegion(path);
        }
        runningAnimation = new Animation(0.1f, runningFrames);
        stateTime = 0f;
        jumpingTexture = textureAtlas.findRegion(Constants.RUNNER_JUMPING_REGION_NAME);
        dodgingTexture = textureAtlas.findRegion(Constants.RUNNER_DODGING_REGION_NAME);
        hitTexture = textureAtlas.findRegion(Constants.RUNNER_HIT_REGION_NAME);
    }

    // animating the runner
    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        if(dodging) {
            batch.draw(dodgingTexture, screenRectangle.x, screenRectangle.y + screenRectangle.height / 4, screenRectangle.width, screenRectangle.height * 3 /4);
        }
        else if(hit) {
            // when he is hit, we also want to apply rotation if the body has been rotated
            batch.draw(hitTexture, screenRectangle.x, screenRectangle.y, screenRectangle.width * 0.5f, screenRectangle.height * 0.5f, screenRectangle.width, screenRectangle.height, 1f, 1f, (float)Math.toDegrees(body.getAngle()));
        }
        else if(jumping) {
            batch.draw(jumpingTexture, screenRectangle.x, screenRectangle.y, screenRectangle.width, screenRectangle.height);
        }
        else {
            // Running
            stateTime += Gdx.graphics.getDeltaTime();
            batch.draw(runningAnimation.getKeyFrame(stateTime, true), screenRectangle.x, screenRectangle.y, screenRectangle.getWidth(), screenRectangle.getHeight());
        }
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
