package com.company.Controller.enemycontroller;

import com.company.Controller.BirdController;
import com.company.Controller.ControllerManager;
import com.company.Controller.SingleController;
import com.company.Models.Enemy;
import com.company.Models.GameConfig;
import com.company.Models.Score;
import com.company.View.ImageDrawer;

import java.util.Random;

/**
 * Created by Tran Tuan An on 5/11/2016.
 */
public class ChimneyControllerManager extends ControllerManager {

    int cout = 400;
    int MAX = 10;
    int tmp = 0;
    public static final int AREA_CHIMNEY = 300;


    @Override
    public void run() {
        super.run();

        Random random = new Random();


        if (tmp < 4) {
            tmp ++;
            int i = 200 + random.nextInt(GameConfig.getInst().getScreenHeight() - 400);
            Enemy chimney1 = new Enemy(cout, GameConfig.getInst().getScreenHeight() - i, Enemy.DEFAULT_CHIMNEY_WIDTH,
                    Enemy.DEFAULT_CHIMNEY_HEIGHT);
            ImageDrawer imageDrawer = new ImageDrawer("resources/chimney.png");
            Enemy chimney2 = new Enemy(cout, GameConfig.getInst().getScreenHeight() - i - 250 - Enemy.DEFAULT_CHIMNEY_HEIGHT,
                    Enemy.DEFAULT_CHIMNEY_WIDTH, Enemy.DEFAULT_CHIMNEY_HEIGHT);
            ImageDrawer imageDrawer1 = new ImageDrawer("resources/chimney2.png");
            ChimneyController chimneyController1 = new ChimneyController(chimney1, imageDrawer);
            ChimneyController chimneyController = new ChimneyController(chimney2, imageDrawer1);
            this.singleControllerVector.add(chimneyController);
            this.singleControllerVector.add(chimneyController1);
            cout += AREA_CHIMNEY;

        }else if (BirdController.getBirdController().getGameObject().getX() >= singleControllerVector.get(0).getGameObject().getX()&&
                singleControllerVector.size() < MAX){
            Score.setScore();
            System.out.println(Score.score);
            int i = 200 + random.nextInt(GameConfig.getInst().getScreenHeight() - 400);
            Enemy chimney1 = new Enemy(singleControllerVector.lastElement().getGameObject().getX()+AREA_CHIMNEY,
                    GameConfig.DEFAULT_SCREEN_HEIGHT - i, Enemy.DEFAULT_CHIMNEY_WIDTH, Enemy.DEFAULT_CHIMNEY_HEIGHT);
            ImageDrawer imageDrawer = new ImageDrawer("resources/chimney.png");
            Enemy chimney2 = new Enemy(singleControllerVector.lastElement().getGameObject().getX()+AREA_CHIMNEY,
                    GameConfig.DEFAULT_SCREEN_HEIGHT - 100 - i - Enemy.DEFAULT_CHIMNEY_HEIGHT, Enemy.DEFAULT_CHIMNEY_WIDTH, Enemy.DEFAULT_CHIMNEY_HEIGHT);
            ImageDrawer imageDrawer1 = new ImageDrawer("resources/chimney2.png");
            ChimneyController chimneyController1 = new ChimneyController(chimney1, imageDrawer);
            ChimneyController chimneyController = new ChimneyController(chimney2, imageDrawer1);
            this.singleControllerVector.add(chimneyController);
            this.singleControllerVector.add(chimneyController1);
        }
//

    }

    private static ChimneyControllerManager inst;
    public static ChimneyControllerManager getInst(){
        if (inst == null){
            inst = new ChimneyControllerManager();
        }
        return inst;
    }

}
