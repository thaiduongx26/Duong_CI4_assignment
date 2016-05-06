package vn.edu.techkids.controllers;


import vn.edu.techkids.models.EnemyBullet;
import vn.edu.techkids.models.GameConfig;
import vn.edu.techkids.views.GameDrawer;

/**
 * Created by qhuydtvt on 5/6/2016.
 */
public class EnemyBulletController extends SingleController implements Colliable{

    public final int HIT = 1;

    public EnemyBulletController(EnemyBullet gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        this.gameVector.dy = 5;
        CollisionPool.getInst().add(this);
    }

    @Override
    public void run() {
        super.run();
        if(!GameConfig.getInst().isInScreen(this.gameObject)){
            this.gameObject.setAlive(false);
        }
    }

    @Override
    public void onCollide(Colliable c) {
        if (c instanceof PlaneController){

            System.out.println(((PlaneController) c).getHp());

            ((PlaneController) c).setHp(((PlaneController) c).getHp() - HIT);
            if (((PlaneController) c).getHp() == 0) {
                c.getGameObject().setAlive(false);
            }
            gameObject.setAlive(false);
        }
    }
}
