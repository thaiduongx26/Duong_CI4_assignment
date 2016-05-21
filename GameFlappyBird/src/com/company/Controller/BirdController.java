package com.company.Controller;

import com.company.Controller.enemycontroller.ChimneyController;
import com.company.Models.Bird;
import com.company.Models.GameConfig;
import com.company.Models.GameObject;
import com.company.Utils;
import com.company.View.AnimationDrawer;
import com.company.View.GameDrawer;
import com.company.gamesences.PlayGameScence;

import java.awt.*;

/**
 * Created by Tran Tuan An on 5/11/2016.
 */
public class BirdController extends SingleController implements Colliable {
    public static int count = 0;
    public final int DEFAULT_DY = 3;
    private int bird_dy;
    public BirdController(GameObject gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        CollisionPool.getInst().add(this);
//        this.gameVector.dy =2;
    }

    public void move(BirdDirection birdDirection) {
        switch (birdDirection) {
            case SPACE:
                gameVector.dy = -6;
//                gameVector.dx = ;
                count = 0;
                Utils.playSound("resources/wing.wav",false);
                break;
            case NONE:
                Utils.playSound("resources/swooshing.wav",false);
                if (count == 0) {
                    gameVector.dy = DEFAULT_DY;
                    bird_dy = this.getGameObject().getY();
                    count = 1;
                } else {
                    gameVector.dy = (this.getGameObject().getY() - bird_dy ) ;
//                    if (this.getGameObject().getY() - bird_dy == 10){
//                        gameVector.dy += 1;
//                    }
                }
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
        if (c instanceof ButterflyController){
            c.getGameObject().setAlive(false);
            System.out.println("va cham vs Butter");
            PlayGameScence.checkButterfly = true ;
        }
    }
}
