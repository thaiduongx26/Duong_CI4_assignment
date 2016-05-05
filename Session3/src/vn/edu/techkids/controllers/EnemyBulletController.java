package vn.edu.techkids.controllers;

import vn.edu.techkids.models.EnemyBullet;
import vn.edu.techkids.models.GameObject;
import vn.edu.techkids.views.GameDrawer;
import vn.edu.techkids.views.ImageDrawer;

/**
 * Created by Wrong on 5/3/2016.
 */
public class EnemyBulletController extends SingleController {

    public final int SPEED = 10;

    public EnemyBulletController(EnemyBullet gameObject, ImageDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        gameVector.dy = SPEED;
    }



}
