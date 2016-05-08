package vn.edu.techkids.controllers;

import vn.edu.techkids.models.*;
import vn.edu.techkids.views.GameDrawer;
import vn.edu.techkids.views.ImageDrawer;

import java.awt.*;

/**
 * Created by qhuydtvt on 5/6/2016.
 */
public class EnemyPlaneController extends SingleControllerWithHP implements Colliable {

    private EnemyBulletControllerManager enemyBulletControllerManager;
    private int count = 0;
    private int typeBulletEnemy ;

    public EnemyPlaneController(EnemyPlane gameObject, GameDrawer gameDrawer,int setDx, int setDy,int typeBulletEnemy) {
        super(gameObject, gameDrawer);
        this.gameVector.dx = setDx;
        this.gameVector.dy = setDy;
        this.typeBulletEnemy = typeBulletEnemy;
        enemyBulletControllerManager = new EnemyBulletControllerManager();
        CollisionPool.getInst().add(this);
    }

    /* TODO override run */

    private void shot(int typeBulletEnemy){
        EnemyBullet enemyBullet = new EnemyBullet(
                gameObject.getX() + gameObject.getWidth() / 2 - EnemyBullet.WIDTH / 2,
                gameObject.getY() + gameObject.getHeight(),
                EnemyBullet.WIDTH,
                EnemyBullet.HEIGHT
        );
        ImageDrawer imageDrawer = new ImageDrawer("resources/enemy_bullet.png");
        EnemyBulletController enemyBulletController = new EnemyBulletController(
                enemyBullet,
                imageDrawer,
                typeBulletEnemy
        );
        this.enemyBulletControllerManager.add(enemyBulletController);
    }

    @Override
    public void run() {
        super.run();
        this.enemyBulletControllerManager.run();

        count++;
        if (GameConfig.getInst().durationInSeconds(count) >= 2) {
            count = 0;
            this.shot(this.typeBulletEnemy);
        }

        if (!GameConfig.getInst().isInScreen(this.gameObject)) {
            this.gameObject.setAlive(false);
        }

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        this.enemyBulletControllerManager.paint(g);
    }

    @Override
    public void onCollide(Colliable c) {
        if(c instanceof PlaneController){
            Plane plane=(Plane)c.getGameObject();
            plane.decreaseHP(2);
        }
    }
}
