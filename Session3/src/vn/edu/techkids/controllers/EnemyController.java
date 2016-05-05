package vn.edu.techkids.controllers;

import vn.edu.techkids.models.Bullet;
import vn.edu.techkids.models.EnemyBullet;
import vn.edu.techkids.models.EnemyPlane;
import vn.edu.techkids.views.GameDrawer;
import vn.edu.techkids.views.ImageDrawer;

import java.awt.*;

import java.util.Calendar;
import java.util.Vector;

/**
 * Created by Wrong on 5/2/2016.
 */
public class EnemyController extends SingleController{

    private int x ;

    public void setX(int x) {
        this.x = x;
    }

    private int count = 0 ;

    private final int SPEED = 3;

    Calendar calendar;



    Vector<EnemyBulletController> enemyBulletControllerVector ;

    public EnemyController(EnemyPlane gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        this.gameVector.dy = SPEED;
        enemyBulletControllerVector = new Vector<EnemyBulletController>();
    }

    public static EnemyController enemyController;

    private EnemyBullet enemyBullet;



    public static EnemyController getEnemyController(){
        if (enemyController == null){
            EnemyPlane enemyPlane = new EnemyPlane(20,20,70,60);
            ImageDrawer enemyDrawer = new ImageDrawer("resources/plane1.png");
            enemyController = new EnemyController(enemyPlane,enemyDrawer);
        }
        return enemyController;
    }


    public void shot(){
        enemyBullet = new EnemyBullet(
                gameObject.getX() + gameObject.getWidth() / 2 - Bullet.DEFAULT_WIDTH / 2,
                gameObject.getY() + gameObject.getHeight(),
                Bullet.DEFAULT_WIDTH,
                Bullet.DEFAULT_HEIGHT);

        ImageDrawer imageDrawer = new ImageDrawer("resources/bullet_enemy.png");

        EnemyBulletController enemyBulletController = new EnemyBulletController(enemyBullet,imageDrawer);
        this.enemyBulletControllerVector.add(enemyBulletController);
        count = 1;
    }

    @Override
    public void run() {
        super.run();
        if (gameObject.getY() == 599){
            gameObject.setY(20);
        }


////        if (calendar.get(13) % 10 == 0) {
        calendar = Calendar.getInstance();

        if (calendar.get(13) % 2 == 0 && count == 0){
            shot();
        }

        if (calendar.get(13) % 2 == 1){
            count = 0;
        }

        for (EnemyBulletController enemyBulletController1 : this.enemyBulletControllerVector) {
            enemyBulletController1.run();
        }
    }

    @Override
    public void paint(Graphics g) {

        super.paint(g);


        for (EnemyBulletController enemyBulletController1: this.enemyBulletControllerVector){
            enemyBulletController1.paint(g);
        }

    }

}
