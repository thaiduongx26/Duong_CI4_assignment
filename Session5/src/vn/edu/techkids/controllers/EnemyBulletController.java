package vn.edu.techkids.controllers;


import vn.edu.techkids.models.EnemyBullet;
import vn.edu.techkids.models.GameConfig;
import vn.edu.techkids.models.Plane;
import vn.edu.techkids.views.GameDrawer;

/**
 * Created by qhuydtvt on 5/6/2016.
 */
public class EnemyBulletController extends SingleController implements Colliable {

    private int type;

    public EnemyBulletController(EnemyBullet gameObject, GameDrawer gameDrawer,int type) {
        super(gameObject, gameDrawer);
        this.type = type;
        switch (type){
            case EnemyBullet.TYPE_NORMAL:
                this.gameVector.dx = EnemyBullet.NORMAL_BULLET_DX;
                this.gameVector.dy = EnemyBullet.NORMAL_BULLET_DY;
                break;
            case EnemyBullet.TYPE_CROSS_RIGHT_TO_LEFT:
                this.gameVector.dx = EnemyBullet.BULLET_VECTO_CROSS_TO_LEFT_DX;
                this.gameVector.dy = EnemyBullet.BULLET_VECTO_CROSS_TO_LEFT_DY;
                break;
            case EnemyBullet.TYPE_CROSS_LEFT_TO_RIGHT:
                this.gameVector.dx = EnemyBullet.BULLET_VECTO_CROSS_TO_RIGHT_DX;
                this.gameVector.dy = EnemyBullet.BULLET_VECTO_CROSS_TO_RIGHT_DY;
                break;
        }
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
            switch (this.type) {
                case EnemyBullet.TYPE_NORMAL:
                    Plane plane = (Plane) c.getGameObject();
                    plane.decreaseHP();
                    if (plane.getHp() <= 0) {
                        plane.setAlive(false);
                    }
                    break;
                case EnemyBullet.TYPE_CROSS_RIGHT_TO_LEFT:
                    plane = (Plane) c.getGameObject();
                    plane.decreaseHP(3);
                    if (plane.getHp() <= 0) {
                        plane.setAlive(false);
                    }
                    break;
            }
        }
    }
}
