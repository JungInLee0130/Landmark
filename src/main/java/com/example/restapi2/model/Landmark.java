package com.example.restapi2.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Landmark {
    private String id;

    private String name;

    private String picture;

    public Landmark(String id, String name, String picture) {
        this.id = id;
        this.name = name;
        this.picture = picture;
    }
}
