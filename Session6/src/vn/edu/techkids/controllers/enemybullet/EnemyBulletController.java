package vn.edu.techkids.controllers.enemybullet;


import vn.edu.techkids.controllers.*;
import vn.edu.techkids.models.EnemyBullet;
import vn.edu.techkids.models.GameConfig;
import vn.edu.techkids.models.GameVector;
import vn.edu.techkids.models.Plane;
import vn.edu.techkids.views.GameDrawer;
import vn.edu.techkids.views.ImageDrawer;

/**
 * Created by qhuydtvt on 5/6/2016.
 */
public class EnemyBulletController extends SingleController implements Colliable {

    public EnemyBulletController(EnemyBullet gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        this.gameVector.dy = 5;
        CollisionPool.getInst().add(this);
    }

    public EnemyBulletController(EnemyBullet gameObject, GameDrawer gameDrawer, GameVector gameVector) {
        super(gameObject, gameDrawer,gameVector);
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
        if (c instanceof PlaneController) {
            Plane plane = (Plane) c.getGameObject();
            EnemyBullet enemyBullet = (EnemyBullet)gameObject;
            plane.decreaseHP(enemyBullet.getDamage());
            if (plane.getHp() <= 0) {
                plane.setAlive(false);
            }
        }
        else if(c instanceof BulletController){
            c.getGameObject().setAlive(false);
        }
    }
    public static EnemyBulletController creat(int x,int y,EnemyBulletType enemyBulletType){
        EnemyBulletController enemyBulletController = null;
        EnemyBullet enemyBullet = new EnemyBullet(x,y,20,20,10);
        ImageDrawer imageDrawer = new ImageDrawer("resources/enemy_bullet.png");
        switch (enemyBulletType) {
            case ENEMY_BULLET_NORMAL:
                enemyBulletController = new EnemyBulletController(
                        enemyBullet,
                        imageDrawer,
                        new GameVector(0, 3)
                );
                break;
            case ENEMY_BULLET_CROSS:
                enemyBulletController = new EnemyBulletController(
                        enemyBullet,
                        imageDrawer,
                        new GameVector(-3, 3)
                );
                break;
        }
        return enemyBulletController;
    }

}
