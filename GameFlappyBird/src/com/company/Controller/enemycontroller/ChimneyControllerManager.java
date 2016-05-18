package com.company.Controller.enemycontroller;

import com.company.Controller.BirdController;
import com.company.Controller.ControllerManager;
import com.company.Controller.SingleController;
import com.company.Models.Enemy;
import com.company.Models.GameConfig;
import com.company.Models.GameObject;
import com.company.Models.Score;
import com.company.View.ImageDrawer;

import java.util.Random;

/**
 * Created by Tran Tuan An on 5/11/2016.
 */
public class ChimneyControllerManager extends ControllerManager {

    public int cout = 400;
    int MAX = 10;
    private int tmp = 0;
    public static final int AREA_CHIMNEY = 300;
    private int speed = 2;
    private static int count = 1;

    public void creat(int i) {
        Enemy chimney1 = new Enemy(GameConfig.DEFAULT_SCREEN_WIDTH, GameConfig.getInst().getScreenHeight() - i, Enemy.DEFAULT_CHIMNEY_WIDTH,
                Enemy.DEFAULT_CHIMNEY_HEIGHT);
        ImageDrawer imageDrawer = new ImageDrawer("resources/chimney.png");
        Enemy chimney2 = new Enemy(GameConfig.DEFAULT_SCREEN_WIDTH, GameConfig.getInst().getScreenHeight() - i - 150 - Enemy.DEFAULT_CHIMNEY_HEIGHT,
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
        System.out.println(singleControllerVector.size());
        Random random = new Random();

        if (count == 1) {
            creat( 200 + random.nextInt(GameConfig.getInst().getScreenHeight() - 400));
        }
        System.out.println(count);
        count = 0;

//        if (tmp < 4) {
//            tmp++;
//            int i = 200 + random.nextInt(GameConfig.getInst().getScreenHeight() - 400);
//            Enemy chimney1 = new Enemy(cout, GameConfig.getInst().getScreenHeight() - i, Enemy.DEFAULT_CHIMNEY_WIDTH,
//                    Enemy.DEFAULT_CHIMNEY_HEIGHT);
//            ImageDrawer imageDrawer = new ImageDrawer("resources/chimney.png");
//            Enemy chimney2 = new Enemy(cout, GameConfig.getInst().getScreenHeight() - i - 300 - Enemy.DEFAULT_CHIMNEY_HEIGHT,
//                    Enemy.DEFAULT_CHIMNEY_WIDTH, Enemy.DEFAULT_CHIMNEY_HEIGHT);
//            ImageDrawer imageDrawer1 = new ImageDrawer("resources/chimney2.png");
//            ChimneyController chimneyController1 = new ChimneyController(chimney1, imageDrawer);
//            ChimneyController chimneyController = new ChimneyController(chimney2, imageDrawer1);
//            this.singleControllerVector.add(chimneyController);
//            this.singleControllerVector.add(chimneyController1);
//            cout += AREA_CHIMNEY;
//        }
//        }else if (BirdController.getBirdController().getGameObject().getX() >= singleControllerVector.get(0).getGameObject().getX()&&
//            singleControllerVector.size() < MAX) {
//                Score.setScore();
//                System.out.println(Score.score);
//
//                speed++;
//                int i = 200 + random.nextInt(GameConfig.getInst().getScreenHeight() - 400);
//                Enemy chimney1 = new Enemy(singleControllerVector.lastElement().getGameObject().getX() + AREA_CHIMNEY,
//                        GameConfig.DEFAULT_SCREEN_HEIGHT - i, Enemy.DEFAULT_CHIMNEY_WIDTH, Enemy.DEFAULT_CHIMNEY_HEIGHT);
//                ImageDrawer imageDrawer = new ImageDrawer("resources/chimney.png");
//                Enemy chimney2 = new Enemy(singleControllerVector.lastElement().getGameObject().getX() + AREA_CHIMNEY,
//                        GameConfig.DEFAULT_SCREEN_HEIGHT - 300 - i - Enemy.DEFAULT_CHIMNEY_HEIGHT, Enemy.DEFAULT_CHIMNEY_WIDTH, Enemy.DEFAULT_CHIMNEY_HEIGHT);
//                ImageDrawer imageDrawer1 = new ImageDrawer("resources/chimney2.png");
//                ChimneyController chimneyController1 = new ChimneyController(chimney1, imageDrawer);
//                ChimneyController chimneyController = new ChimneyController(chimney2, imageDrawer1);
//                this.singleControllerVector.add(chimneyController);
//                this.singleControllerVector.add(chimneyController1);
//                count = 0;
//                if (Score.score % 2 == 0) {
//                    ChimneyController.speed += 1;
//                }
////           if (Score.score %5 == 0) ChimneyController.setSpeed(4);
//        }


    }

    public GameObject getGameObject() {
        return getGameObject();
    }

//    public void setTmp(int tmp) {
//        this.tmp = tmp;
//    }


    private static ChimneyControllerManager inst;


    public static ChimneyControllerManager getInst() {
        if (inst == null) {
            inst = new ChimneyControllerManager();
        }
        return inst;
    }
}


