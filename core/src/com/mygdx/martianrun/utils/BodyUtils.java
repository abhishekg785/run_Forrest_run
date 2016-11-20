package com.mygdx.martianrun.utils;

import com.badlogic.gdx.physics.box2d.Body;
import com.mygdx.martianrun.box2d.UserData;
import com.mygdx.martianrun.enums.UserDataType;

/**
 * Created by hiro on 18/11/16.
 */
public class BodyUtils {

    // check whether the body is
    public static boolean bodyIsRunner(Body body) {
        UserData userData = (UserData) body.getUserData();

        return userData != null && userData.getUserDataType() == UserDataType.RUNNER;
    }

    // check whether the body is a ground or not
    public static boolean bodyIsGround(Body body) {
        UserData userData = (UserData) body.getUserData();

        return userData != null && userData.getUserDataType() == UserDataType.GROUND;
    }

    // to check whether the body is enemy or not
    public static boolean bodyIsEnemey(Body body) {
        UserData userData = (UserData) body.getUserData();

        return  userData != null && userData.getUserDataType() == UserDataType.ENEMY;
    }

    // to check whether the body is in bounds or not
    public static boolean bodyInBounds(Body body) {
        UserData userData = (UserData)body.getUserData();

        switch (userData.getUserDataType()) {
            case RUNNER:
            case ENEMY:
                return  body.getPosition().x + userData.getWidth() / 2 > 0;
        }

        return true;
    }
 }
