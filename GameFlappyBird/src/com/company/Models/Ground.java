package com.company.Models;

/**
 * Created by Wrong on 5/15/2016.
 */
public class Ground extends GameObject{
    public static final int DEFAULT_GROUND_WIDTH = 800;
    public static final int DEFAULT_GROUND_HEIGHT = 50;

    public Ground() {
        super(0, GameConfig.DEFAULT_SCREEN_HEIGHT - DEFAULT_GROUND_HEIGHT, DEFAULT_GROUND_WIDTH, DEFAULT_GROUND_HEIGHT);
    }
}
