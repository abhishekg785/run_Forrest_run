package com.mygdx.martianrun.box2d;

import com.mygdx.martianrun.enums.UserDataType;

/**
 * Created by hiro on 18/11/16.
 */
public abstract class UserData {

    protected UserDataType userDataType;

    public  UserData() {
    }

    public UserDataType getUserDataType() {
        return  userDataType;
    }
}
