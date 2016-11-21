package com.mygdx.martianrun.actors;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;
import com.mygdx.martianrun.box2d.EnemyUserData;
import com.mygdx.martianrun.utils.Constants;

/**
 * Created by hiro on 20/11/16.
 */
public class Enemy extends GameActor {

    private Animation animation;
    private float stateTime;

    public Enemy(Body body) {

        super(body);
        TextureAtlas textureAtlas = new TextureAtlas(Constants.CHARACTERS_ATLAS_PATH);
//        TextureRegion[]
    }

    @Override
    public EnemyUserData getUserData() {
        return (EnemyUserData) userData;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        body.setLinearVelocity(getUserData().getLinearVelocity());
    }
}
