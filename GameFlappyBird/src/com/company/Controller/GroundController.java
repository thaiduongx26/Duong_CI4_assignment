package com.company.Controller;

import com.company.Models.Bird;
import com.company.Models.GameObject;
import com.company.Models.Ground;
import com.company.View.GameDrawer;
import com.company.View.ImageDrawer;

import java.awt.*;

/**
 * Created by Wrong on 5/15/2016.
 */
public class GroundController extends SingleController implements Colliable{
    public GroundController(GameObject gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        CollisionPool.getInst().add(this);
    }
    private static GroundController groundController;

    public static GroundController getGroundController() {
        if (groundController == null) {
            Ground ground = new Ground();
            ImageDrawer birdDrawer = new ImageDrawer("resources/ground.png");
            groundController = new GroundController(ground, birdDrawer);
        }
        return groundController;
    }
    @Override
    public void onColliable(Colliable c) {
        if (c instanceof BirdController){
            c.getGameObject().setAlive(false);
        }
    }

    @Override
    public void run() {
        super.run();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }
}
