package com.forbitbd.quizapp.model;

import java.io.Serializable;

public class Category implements Serializable {
    private String _id;
    private String name;

    public Category() {
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}