package com.company.Controller;

import com.company.Controller.enemycontroller.ChimneyController;
import com.company.Models.Bird;
import com.company.Models.Enemy;
import com.company.Models.GameConfig;
import com.company.Models.GameObject;
import com.company.View.AnimationDrawer;
import com.company.View.GameDrawer;
import com.company.View.ImageDrawer;

import java.awt.*;

/**
 * Created by Tran Tuan An on 5/11/2016.
 */
public class BirdController extends SingleController implements Colliable {
    private static int count = 0;
    public BirdController(GameObject gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        CollisionPool.getInst().add(this);
//        this.gameVector.dy =2;
    }

    public void move(BirdDirection birdDirection) {
        switch (birdDirection) {
            case SPACE:
                gameVector.dy = -5;
//                gameVector.dx = ;
                break;
            case NONE:
                gameVector.dy = 3;
                break;
        }
    }



    private static BirdController birdController;

    public static BirdController getBirdController() {
        if (birdController == null) {
            Bird bird = new Bird(100, 250, 50, 50);
            AnimationDrawer birdNormal = new AnimationDrawer(
                    new String[] {
                            "resources/bird11.png",
                            "resources/bird12.png",
                            "resources/bird13.png",
                    }
            );
            birdController = new BirdController(bird, birdNormal);
        }
        return birdController;
    }


    @Override
    public void run() {
        if (this.gameObject.isAlive()) {
            Rectangle pointNext = this.gameObject.getNextRect(gameVector);
            if (GameConfig.getInst().isInScreen(pointNext)) {
                super.run();
            } else {
                this.gameObject.setAlive(false);
            }
        }else{
            SingleController.setIsPause(true);
        }
    }

    @Override
    public void paint(Graphics g) {
        if (this.getGameObject().isAlive()) {
            super.paint(g);
        }
    }

    @Override
    public void onColliable(Colliable c) {
        if (c instanceof ChimneyController) {
//            Enemy chimneyController = (Enemy) c.getGameObject();
//            this.getGameObject().setAlive(false);
            System.out.println(c.getGameObject().getX() + " + " + c.getGameObject().getY());

        }
        if(!GameConfig.getInst().isInScreen(this.gameObject.getNextRect(gameVector))){
            this.getGameObject().setAlive(false);
        }
    }
}
