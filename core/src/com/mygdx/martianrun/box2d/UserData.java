package com.mygdx.martianrun.box2d;

import com.mygdx.martianrun.enums.UserDataType;

/**
 * Created by hiro on 18/11/16.
 */
public abstract class UserData {

    protected UserDataType userDataType;
    protected float height;
    protected float width;

    public UserData() {

    }

    public UserDataType getUserDataType() {
        return  userDataType;
    }

    public UserData(float width, float height) {
        this.width = width;
        this.height = height;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }
}
