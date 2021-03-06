package com.company.Models;

/**
 * Created by Tran Tuan An on 5/11/2016.
 */
public class Enemy extends GameObject {

    public static final int DEFAULT_CHIMNEY_HEIGHT = 500;
    public static final int DEFAULT_CHIMNEY_WIDTH = 80;
    public static final int DEFAULT_SPEED = 2;
    public static int DEFAULT_AREA_BETWEEN_CHIMNEY = 150;

    public Enemy(int x, int y, int width, int height) {
        super(x, y, width, height);
    }
}
