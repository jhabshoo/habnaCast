package dev.habna.habnacast.Models;

import java.io.Serializable;

/**
 * Created by jhabshoosh on 7/8/14.
 */
public abstract class BaseModel implements BaseInterface, Serializable {

    private String name;

    BaseModel() {
        name = "";
    }

    BaseModel(String name)   {
        this.name = name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
