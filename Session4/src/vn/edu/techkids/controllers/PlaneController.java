package vn.edu.techkids.controllers;


import vn.edu.techkids.models.Bullet;
import vn.edu.techkids.models.Plane;
import vn.edu.techkids.views.GameDrawer;
import vn.edu.techkids.views.ImageDrawer;

import java.awt.*;
import java.util.Vector;

/**
 * Created by qhuydtvt on 4/29/2016.
 */
public class PlaneController extends SingleController implements Colliable{

    public final int SPEED = 3;
    public final int MAX_BULLET_COUNT = 3;

    private PlaneControllerManager planeControllerManager = new PlaneControllerManager();
    private BulletControllerManager bulletControllerManager;

    private int Hp = 5;

    public int getHp() {
        return Hp;
    }

    public void setHp(int hp) {
        Hp = hp;
    }

    PlaneController(Plane gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        bulletControllerManager = new BulletControllerManager();
    }

    public void move(PlaneDirection planeDirection) {
        switch (planeDirection) {
            case NONE:
                break;
            case UP:
                this.gameVector.dy = -SPEED;
                break;
            case DOWN:
                this.gameVector.dy = SPEED;
                break;
            case LEFT:
                this.gameVector.dx = -SPEED;
                break;
            case RIGHT:
                this.gameVector.dx = SPEED;
                break;
            case STOP_X:
                this.gameVector.dx = 0;
                break;
            case STOP_Y:
                this.gameVector.dy = 0;
                break;
        }
    }

    public void shot() {
        if(bulletControllerManager.size() < MAX_BULLET_COUNT) {
            Bullet bullet = new Bullet(
                    gameObject.getX() + gameObject.getWidth() / 2 - Bullet.DEFAULT_WIDTH / 2,
                    gameObject.getY(),
                    Bullet.DEFAULT_WIDTH,
                    Bullet.DEFAULT_HEIGHT
            );
            ImageDrawer imageDrawer = new ImageDrawer("resources/bullet.png");
            BulletController bulletController = new BulletController(
                    bullet,
                    imageDrawer
            );

            this.bulletControllerManager.add(bulletController);
        }
    }

    private static PlaneController planeController1;
    public static PlaneController getPlaneController1() {
        if(planeController1 == null) {
            Plane plane = new Plane(100, 500, 70, 60);
            ImageDrawer planeDrawer = new ImageDrawer("resources/plane4.png");
            planeController1 = new PlaneController(plane, planeDrawer);

        }
        return planeController1;
    }

    @Override
    public void run() {
        super.run();
        bulletControllerManager.run();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        bulletControllerManager.paint(g);
    }

    @Override
    public void onCollide(Colliable c) {

    }

    /* TODO: Work on the second plane */
}
