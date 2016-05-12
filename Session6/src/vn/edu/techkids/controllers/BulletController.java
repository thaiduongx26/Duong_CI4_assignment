package vn.edu.techkids.controllers;

import vn.edu.techkids.controllers.enemybullet.EnemyBulletController;
import vn.edu.techkids.controllers.enemyplanes.EnemyPlaneController;
import vn.edu.techkids.models.Bullet;
import vn.edu.techkids.models.EnemyPlane;
import vn.edu.techkids.models.GameConfig;
import vn.edu.techkids.models.GameVector;
import vn.edu.techkids.views.ImageDrawer;

/**
 * Created by qhuydtvt on 4/29/2016.
 */
public class BulletController extends SingleController implements Colliable {

    public static final int SPEED_DEFAULT = 15;

    public BulletController(Bullet gameObject, ImageDrawer gameDrawer) {
        super(gameObject, gameDrawer);
//        this.gameVector.dy = -SPEED;
        this.gameVector.dy = SPEED_DEFAULT;
        CollisionPool.getInst().add(this);
    }

    public BulletController(Bullet gameObject, ImageDrawer gameDrawer,int speed,int damage) {
        super(gameObject, gameDrawer);
        this.gameVector.dy = -speed;
        gameObject.setDamage(damage);
        CollisionPool.getInst().add(this);
    }


    @Override
    public void run() {
        super.run();
        if (!GameConfig.getInst().isInScreen(this.gameObject)) {
            this.gameObject.setAlive(false);
        }
    }

    @Override
    public void onCollide(Colliable c) {
        if (c instanceof EnemyPlaneController) {
            EnemyPlane enemyPlane = (EnemyPlane) c.getGameObject();
            Bullet bullet = (Bullet)gameObject;
            enemyPlane.decreaseHP(bullet.getDamage());
            if (enemyPlane.getHp() <= 0) {
                enemyPlane.setAlive(false);
            }
            gameObject.setAlive(false);
        }
        else if(c instanceof EnemyBulletController){
            c.getGameObject().setAlive(false);
        }
    }
}







