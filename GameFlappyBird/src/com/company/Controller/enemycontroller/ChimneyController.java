package com.company.Controller.enemycontroller;

import com.company.Controller.BirdController;
import com.company.Controller.Colliable;
import com.company.Controller.CollisionPool;
import com.company.Controller.SingleController;
import com.company.Models.Enemy;
import com.company.Models.GameConfig;
import com.company.Models.GameObject;
import com.company.Models.GameVector;
import com.company.View.GameDrawer;
import com.company.View.ImageDrawer;

import java.util.Vector;

/**
 * Created by Tran Tuan An on 5/11/2016.
 */
public class ChimneyController extends SingleController implements Colliable {

    public static int speed = 2;
    public ChimneyController(GameObject gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        CollisionPool.getInst().add(this);
    }


//    @Override
//    public void run() {
//        super.run();
//        gameVector.dx = -speed;
//        if (gameObject.getX() < 0 - Enemy.DEFAULT_CHIMNEY_WIDTH){
//            gameObject.setAlive(false);
//        }
//    }

    @Override
    public void run() {
        super.run();
        gameVector.dx = -speed;
        if (gameObject.getX()+gameObject.getWidth() <= 0){
            gameObject.setX(GameConfig.getInst().getScreenWidth());
        }
    }

    @Override
    public void onColliable(Colliable c) {
        if (c instanceof BirdController){
            c.getGameObject().setAlive(false);
        }
//        if(!GameConfig.getInst().isInScreen(this.getGameObject().getNextRect(gameVector))){
//            this.getGameObject().setAlive(false);
//        }

    }


}
