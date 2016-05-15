package com.company.Controller;

import com.company.Controller.enemycontroller.ChimneyController;
import com.company.Models.Bird;
import com.company.Models.Enemy;
import com.company.Models.GameConfig;
import com.company.Models.GameObject;
import com.company.View.GameDrawer;
import com.company.View.ImageDrawer;

import java.awt.*;

/**
 * Created by Tran Tuan An on 5/11/2016.
 */
public class BirdController extends SingleController implements Colliable {
    private static int count = 0;
    private BirdController(GameObject gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        gameVector.dy =3;
        CollisionPool.getInst().add(this);
//        this.gameVector.dy =2;
    }

    public void move(BirdDirection birdDirection) {
        switch (birdDirection) {
            case SPACE:
                gameVector.dy = -6;
//                gameVector.dx = ;
                break;
            case NONE:
                gameVector.dy = 4;
                break;
        }
    }

    private static BirdController birdController;

    public static BirdController getBirdController() {
        if (birdController == null) {
            Bird bird = new Bird(100, 200, 40, 30);
            ImageDrawer birdDrawer = new ImageDrawer("resources/bird.png");
            birdController = new BirdController(bird, birdDrawer);
        }
        return birdController;
    }


    @Override
    public void run() {
        if (this.gameObject.isAlive()) {
//            SingleController.setIsPause(false);
            Rectangle pointNext = this.gameObject.getNextRect(gameVector);
            if (GameConfig.getInst().isInScreen(pointNext)) {
                super.run();
            } else {
                this.gameObject.setAlive(false);
            }
        }
//        else {
//            SingleController.setIsPause(true);
//        }

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
            Enemy chimneyController = (Enemy) c.getGameObject();
            this.getGameObject().setAlive(false);
        }
        if(!GameConfig.getInst().isInScreen(this.gameObject.getNextRect(gameVector))){
            this.getGameObject().setAlive(false);
        }
    }
}
