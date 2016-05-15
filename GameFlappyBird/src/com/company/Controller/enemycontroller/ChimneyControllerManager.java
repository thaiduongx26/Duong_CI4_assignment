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

    public static int cout = 400;
    int MAX = 10;
    int tmp = 0;
    public static final int AREA_CHIMNEY = 300;
    private int speed = 2;
    private int count = 0;

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
            Enemy chimney2 = new Enemy(cout, GameConfig.getInst().getScreenHeight() - i - 120 - Enemy.DEFAULT_CHIMNEY_HEIGHT,
                    Enemy.DEFAULT_CHIMNEY_WIDTH, Enemy.DEFAULT_CHIMNEY_HEIGHT);
            ImageDrawer imageDrawer1 = new ImageDrawer("resources/chimney2.png");
            ChimneyController chimneyController1 = new ChimneyController(chimney1, imageDrawer);
            ChimneyController chimneyController = new ChimneyController(chimney2, imageDrawer1);
            this.singleControllerVector.add(chimneyController);
            this.singleControllerVector.add(chimneyController1);
            cout += AREA_CHIMNEY;
        }else if (BirdController.getBirdController().getGameObject().getX() >= singleControllerVector.get(0).getGameObject().getX()&&
                singleControllerVector.size() < MAX || count>=1){
            Score.setScore();
            System.out.println(Score.score);

            speed++;
            int i = 200 + random.nextInt(GameConfig.getInst().getScreenHeight() - 400);
            Enemy chimney1 = new Enemy(singleControllerVector.lastElement().getGameObject().getX()+AREA_CHIMNEY,
                    GameConfig.DEFAULT_SCREEN_HEIGHT - i, Enemy.DEFAULT_CHIMNEY_WIDTH, Enemy.DEFAULT_CHIMNEY_HEIGHT);
            ImageDrawer imageDrawer = new ImageDrawer("resources/chimney.png");
            Enemy chimney2 = new Enemy(singleControllerVector.lastElement().getGameObject().getX()+AREA_CHIMNEY,
                    GameConfig.DEFAULT_SCREEN_HEIGHT - 120 - i - Enemy.DEFAULT_CHIMNEY_HEIGHT, Enemy.DEFAULT_CHIMNEY_WIDTH, Enemy.DEFAULT_CHIMNEY_HEIGHT);
            ImageDrawer imageDrawer1 = new ImageDrawer("resources/chimney2.png");
            ChimneyController chimneyController1 = new ChimneyController(chimney1, imageDrawer);
            ChimneyController chimneyController = new ChimneyController(chimney2, imageDrawer1);
            this.singleControllerVector.add(chimneyController);
            this.singleControllerVector.add(chimneyController1);
            count = 0;
//            if (Score.score % 5 ==0) {
//                for (SingleController singleController : singleControllerVector) {
//                    if (singleController instanceof ChimneyController) {
//                        ((ChimneyController) singleController).speed = 20;
//                    }
//                }
//            }
//           if (Score.score %5 == 0) ChimneyController.setSpeed(4);
        }
//

    }

    public GameObject getGameObject(){
        return getGameObject();
    }

    public void setTmp(int tmp) {
        this.tmp = tmp;
    }


    private static ChimneyControllerManager inst;



    public static ChimneyControllerManager getInst(){
        if (inst == null){
            inst = new ChimneyControllerManager();
        }
        return inst;
    }

}
