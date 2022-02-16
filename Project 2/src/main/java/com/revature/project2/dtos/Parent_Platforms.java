package com.revature.project2.dtos;

public class Parent_Platforms {
    private Platform platform;

    public Parent_Platforms() {
    }

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    @Override
    public String toString() {
        return "Parent_Platforms{" +
                "platform=" + platform +
                '}';
    }
}
