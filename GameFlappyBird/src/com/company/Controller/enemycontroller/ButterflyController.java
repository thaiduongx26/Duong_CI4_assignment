package com.company.Controller.enemycontroller;

import com.company.Controller.Colliable;
import com.company.Controller.CollisionPool;
import com.company.Controller.SingleController;
import com.company.Models.Enemy;
import com.company.View.GameDrawer;

import java.awt.*;

/**
 * Created by Wrong on 5/21/2016.
 */
public class ButterflyController extends SingleController implements Colliable {

    private int count = 1;

    public ButterflyController(Enemy gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        CollisionPool.getInst().add(this);
    }

    @Override
    public void run() {
        super.run();
//        this.getGameObject().setX(this.getGameObject().getX() - 10);
//        this.getGameObject().setY((300 + (int) (Math.sin(400 - this.gameObject.getX())*200)));
//
//        System.out.println(getGameObject().getX() +"+"+ getGameObject().getY());
        gameVector.dx = -2;
        if(this.getGameObject().getY() >= 433){
            gameVector.dy = -3;
            count = 0;
        }
        else if(this.getGameObject().getY() <= 100) {
            gameVector.dy = 3;
            count = 1;
        }else if (count == 1){
            gameVector.dy = 3;
        }else gameVector.dy = -3;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }

    @Override
    public void onColliable(Colliable c) {

    }
}
