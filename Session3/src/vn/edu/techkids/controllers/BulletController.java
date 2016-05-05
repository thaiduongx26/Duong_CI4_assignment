package vn.edu.techkids.controllers;

import vn.edu.techkids.models.Bullet;
import vn.edu.techkids.models.EnemyPlane;
import vn.edu.techkids.models.GameObject;
import vn.edu.techkids.views.ImageDrawer;

/**
 * Created by qhuydtvt on 4/29/2016.
 */
public class BulletController extends SingleController {

    public int SPEED = 15;


    public BulletController(Bullet gameObject, ImageDrawer gameDrawer) {
        super(gameObject, gameDrawer);

        gameVector.dy = -SPEED;
    }



    public boolean check(EnemyController enemyController){

        boolean boo = false;

        if (this.getGameObject().getY() == enemyController.getGameObject().getY()
                && this.getGameObject().getX() >= enemyController.getGameObject().getX()
                && this.getGameObject().getX() <= enemyController.getGameObject().getX()+70 )
        {
            boo = true;
        }

        return boo;
    }


}
