package vn.edu.techkids.controllers;

import vn.edu.techkids.models.EnemyBullet;
import vn.edu.techkids.models.EnemyPlane;
import vn.edu.techkids.models.GameConfig;
import vn.edu.techkids.views.ImageDrawer;

/**
 * Created by qhuydtvt on 5/6/2016.
 */
public class EnemyPlaneControllerManager extends ControllerManager {

    private int count = 0;

    private EnemyPlane enemyPlane;

    private EnemyPlaneControllerManager() {
        super();
    }

    private EnemyPlaneController setEnemy2(){
        this.enemyPlane= new EnemyPlane(100, 100, 32, 32);
        ImageDrawer imageDrawer =
                new ImageDrawer("resources/plane1.png");
        EnemyPlaneController enemyPlaneController = new EnemyPlaneController(
                this.enemyPlane,
                imageDrawer,
                EnemyPlane.SPEED_VECTO_CROSS_DX,
                EnemyPlane.SPEED_VECTO_CROSS_DY,
                EnemyBullet.TYPE_CROSS_RIGHT_TO_LEFT
        );
        return enemyPlaneController;
    }

    private EnemyPlaneController setEnemy1(int x){

        EnemyPlane enemyPlane= new EnemyPlane(x, 0, 32, 32);
        ImageDrawer imageDrawer =
                new ImageDrawer("resources/plane1.png");
        EnemyPlaneController enemyPlaneController = new EnemyPlaneController(
                enemyPlane,
                imageDrawer,
                EnemyPlane.DEFAULT_VECTO_FLY_DX,
                EnemyPlane.DEFAULT_VECTO_FLY_DY,
                EnemyBullet.TYPE_NORMAL
        );
        return enemyPlaneController;
    }

    @Override
    public void run() {
        super.run();
        count++;

        if (this.enemyPlane == null || !GameConfig.getInst().isInScreen(this.enemyPlane)) {
            EnemyPlaneController enemyPlaneController1 = this.setEnemy2();
            this.singleControllerVector.add(enemyPlaneController1);
        }
        if(GameConfig.getInst().durationInSeconds(count) > 4) {
            count = 0;
            for (int x = 40; x < GameConfig.getInst().getScreenWidth() - 40; x += 100) {
                EnemyPlaneController enemyPlaneController = this.setEnemy1(x);
                this.singleControllerVector.add(enemyPlaneController);
            }
        }
    }

    private static EnemyPlaneControllerManager inst;
    public static EnemyPlaneControllerManager getInst() {
        if(inst == null) {
            inst = new EnemyPlaneControllerManager();
        }

        return inst;
    }
}
