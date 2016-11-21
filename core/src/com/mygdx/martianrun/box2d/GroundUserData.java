package com.mygdx.martianrun.box2d;

import com.mygdx.martianrun.enums.UserDataType;

/**
 * Created by hiro on 18/11/16.
 */
public class GroundUserData extends UserData {
    public GroundUserData() {
        super();
        userDataType = UserDataType.GROUND;
    }

    public GroundUserData(float width, float height) {
        super(width, height);
        userDataType = userDataType.GROUND;
    }
}
