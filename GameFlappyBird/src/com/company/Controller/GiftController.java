package com.company.Controller;

import com.company.Models.Enemy;
import com.company.Models.GameObject;
import com.company.View.GameDrawer;

import java.awt.*;

/**
 * Created by Wrong on 5/21/2016.
 */
public class GiftController extends SingleController implements Colliable{

public static int check = 0;

    public GiftController(GameObject gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        gameVector.dx = -4;
        CollisionPool.getInst().add(this);
    }



    @Override
    public void run() {
        super.run();

    }

    @Override
    public void paint(Graphics g) {
        if (gameObject.isAlive()) {
            super.paint(g);
        }
    }

    @Override
    public void onColliable(Colliable c) {
        if (c instanceof BirdController){
            this.gameObject.setAlive(false);
            Enemy.DEFAULT_AREA_BETWEEN_CHIMNEY = 200;
        }
    }
}
