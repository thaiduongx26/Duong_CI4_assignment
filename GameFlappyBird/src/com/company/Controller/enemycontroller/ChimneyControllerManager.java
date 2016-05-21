package com.company.Controller.enemycontroller;

import com.company.Controller.*;
import com.company.Models.*;
import com.company.Utils;
import com.company.View.ImageDrawer;
import com.company.gamesences.PlayGameScence;

import java.util.Iterator;
import java.util.Random;

/**
 * Created by Tran Tuan An on 5/11/2016.
 */
public class ChimneyControllerManager extends ControllerManager {

    private int cout = 1;
    private int count = 1;
    private int count_score = 1;


    public void creat(int i){
        Enemy chimney1 = new Enemy(GameConfig.DEFAULT_SCREEN_WIDTH, GameConfig.getInst().getScreenHeight() - i, Enemy.DEFAULT_CHIMNEY_WIDTH,
                Enemy.DEFAULT_CHIMNEY_HEIGHT);
        ImageDrawer imageDrawer = new ImageDrawer("resources/chimney.png");
        Enemy chimney2 = new Enemy(GameConfig.DEFAULT_SCREEN_WIDTH, GameConfig.getInst().getScreenHeight() - i - Enemy.DEFAULT_AREA_BETWEEN_CHIMNEY - Enemy.DEFAULT_CHIMNEY_HEIGHT,
                Enemy.DEFAULT_CHIMNEY_WIDTH, Enemy.DEFAULT_CHIMNEY_HEIGHT);
        ImageDrawer imageDrawer1 = new ImageDrawer("resources/chimney2.png");
        ChimneyController chimneyController1 = new ChimneyController(chimney1, imageDrawer);
        ChimneyController chimneyController = new ChimneyController(chimney2, imageDrawer1);
        this.singleControllerVector.add(chimneyController);
        this.singleControllerVector.add(chimneyController1);
    }

    @Override
    public void run() {
        super.run();

        Random random = new Random();
//        if (!PlayGameScence.checkDeleteChimney) {
        if (singleControllerVector.size() == 0 || singleControllerVector.size()==1) {
            creat(200 + random.nextInt(GameConfig.getInst().getScreenHeight() - 400));
        } else if (GameConfig.DEFAULT_SCREEN_WIDTH - singleControllerVector.get(singleControllerVector.size() - 1).getGameObject().getX() == 300) {
            creat(200 + random.nextInt(GameConfig.getInst().getScreenHeight() - 400));
        }



        /* set Score here */
//
        if (BirdController.getBirdController().getGameObject().getX() <= singleControllerVector.get(0).getGameObject().getX()) {
            count = 1;
//            if(Score.score % 5 == 0 && Score.score !=0 && count_score == 1){
//                ChimneyController.addSpeed();
//                count_score = 0;
//            }
//            if(Score.score % 5 != 0 && count_score == 0){
//                count_score = 1;
//            }
        }
        if (count == 1 &&
                BirdController.getBirdController().getGameObject().getX() >= singleControllerVector.get(0).getGameObject().getX()
                + Enemy.DEFAULT_CHIMNEY_WIDTH / 2) {
            count = 0;
            Score.setScore();
            Utils.playSound("resources/score.wav",false);
//            if(Score.score % 5 == 0 && Score.score !=0 && count_score == 1){
//                ChimneyController.addSpeed();
//                count_score = 0;
//            }
//            if(Score.score % 5 != 0 && count_score == 0){
//                count_score = 1;
//            }
        }


//        } else {
//
//
//            PlayGameScence.checkDeleteChimney = false;
//        }



//        if (tmp <=4) {
//            tmp ++;
//            int i = 200 + random.nextInt(GameConfig.getInst().getScreenHeight() - 400);
//            Enemy chimney1 = new Enemy(cout, GameConfig.getInst().getScreenHeight() - i, Enemy.DEFAULT_CHIMNEY_WIDTH,
//                    Enemy.DEFAULT_CHIMNEY_HEIGHT);
//            ImageDrawer imageDrawer = new ImageDrawer("resources/chimney.png");
//            Enemy chimney2 = new Enemy(cout, GameConfig.getInst().getScreenHeight() - i - 100 - Enemy.DEFAULT_CHIMNEY_HEIGHT,
//                    Enemy.DEFAULT_CHIMNEY_WIDTH, Enemy.DEFAULT_CHIMNEY_HEIGHT);
//            ImageDrawer imageDrawer1 = new ImageDrawer("resources/chimney2.png");
//            ChimneyController chimneyController1 = new ChimneyController(chimney1, imageDrawer);
//            ChimneyController chimneyController = new ChimneyController(chimney2, imageDrawer1);
//            this.singleControllerVector.add(chimneyController);
//            this.singleControllerVector.add(chimneyController1);
//            cout += AREA_CHIMNEY;
//
//        }else if (BirdController.getBirdController().getGameObject().getX() >= singleControllerVector.get(0).getGameObject().getX()&&
//                singleControllerVector.size() < MAX){
//
//            int i = 200 + random.nextInt(GameConfig.getInst().getScreenHeight() - 400);
//            Enemy chimney1 = new Enemy(singleControllerVector.lastElement().getGameObject().getX()+300,
//                    600 - i, Enemy.DEFAULT_CHIMNEY_WIDTH, Enemy.DEFAULT_CHIMNEY_HEIGHT);
//            ImageDrawer imageDrawer = new ImageDrawer("resources/chimney.png");
//            Enemy chimney2 = new Enemy(singleControllerVector.lastElement().getGameObject().getX()+300,
//                    500 - i - Enemy.DEFAULT_CHIMNEY_HEIGHT, Enemy.DEFAULT_CHIMNEY_WIDTH, Enemy.DEFAULT_CHIMNEY_HEIGHT);
//            ImageDrawer imageDrawer1 = new ImageDrawer("resources/chimney2.png");
//            ChimneyController chimneyController1 = new ChimneyController(chimney1, imageDrawer);
//            ChimneyController chimneyController = new ChimneyController(chimney2, imageDrawer1);
//            this.singleControllerVector.add(chimneyController);
//            this.singleControllerVector.add(chimneyController1);
//        }


    }

    public void reset(){
        for (Colliable colliable: CollisionPool.getInst().getColliableVector()){
            if (colliable instanceof ChimneyController ){
                colliable.getGameObject().setAlive(false);
            }
        }
        Iterator<SingleController> iterator = singleControllerVector.iterator();
        while (iterator.hasNext()){
            SingleController s = iterator.next();
            if (s instanceof ChimneyController){
                iterator.remove();
            }
        }
        Score.score = 0;
        ChimneyController.setSpeed(Enemy.DEFAULT_SPEED);
    }

    private static ChimneyControllerManager inst;
    public static ChimneyControllerManager getInst(){
        if (inst == null){
            inst = new ChimneyControllerManager();
        }
        return inst;
    }

}
