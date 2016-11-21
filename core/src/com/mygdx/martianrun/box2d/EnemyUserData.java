package com.mygdx.martianrun.box2d;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.martianrun.actors.Enemy;
import com.mygdx.martianrun.enums.UserDataType;
import com.mygdx.martianrun.utils.Constants;

/**
 * Created by hiro on 20/11/16.
 */
public class EnemyUserData extends UserData {

    private Vector2 linearVelocity;
    private String[] textureRegions;

    public EnemyUserData() {

    }

    public EnemyUserData(float width, float height, String[] textureRegions) {
        super(width, height);
        userDataType = UserDataType.ENEMY;
        linearVelocity = Constants.ENEMY_LINEAR_VELOCITY;
        this.textureRegions = textureRegions;
    }

    public void setLinearVelocity(Vector2 linearVelocity) {
        this.linearVelocity = linearVelocity;
    }

    public Vector2 getLinearVelocity() {
        return linearVelocity;
    }

    public String[] getTextureRegions() {
        return textureRegions;
    }
}
