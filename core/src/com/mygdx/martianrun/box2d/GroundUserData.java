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
}
