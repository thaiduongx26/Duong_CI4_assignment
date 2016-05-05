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
public class PlaneController extends SingleController {

    public final int SPEED = 10;
    public final int MAX_BULLET_COUNT = 100;

    private Vector<BulletController> bulletControllerVector;

    private PlaneController(Plane gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        bulletControllerVector = new Vector<BulletController>();
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
        if(bulletControllerVector.size() < MAX_BULLET_COUNT) {
            Bullet bullet = new Bullet(
                    gameObject.getX() + gameObject.getWidth() / 2 - Bullet.DEFAULT_WIDTH / 2,
                    gameObject.getY(),
                    Bullet.DEFAULT_WIDTH,
                    Bullet.DEFAULT_HEIGHT
            );
            ImageDrawer imageDrawer = new ImageDrawer("resources/bullet.png");
            BulletController bulletController = new BulletController(
                    bullet,
                    imageDrawer);
            this.bulletControllerVector.add(bulletController);
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
        for(BulletController bulletController : this.bulletControllerVector) {
            bulletController.run();
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for(BulletController bulletController : this.bulletControllerVector) {
            bulletController.paint(g);
        }
    }

    /* TODO: Work on the second plane */

    private static PlaneController planeController2;

    public static PlaneController getPlaneController2() {
        if(planeController2 == null) {
            Plane plane = new Plane(300, 500, 70, 60);
            ImageDrawer planeDrawer = new ImageDrawer("resources/plane3.png");
            planeController2 = new PlaneController(plane, planeDrawer);
        }
        return planeController2;
    }


    private int xOfMouse;
    private int yOfMouse;

    public void setxOfMouse(int xOfMouse) {
        this.xOfMouse = xOfMouse;
    }

    public void setyOfMouse(int yOfMouse) {
        this.yOfMouse = yOfMouse;
    }

    public int getxOfMouse() {
        return xOfMouse;
    }

    public int getyOfMouse() {
        return yOfMouse;
    }

    public PlaneDirection planeDirection1(int x){
        PlaneDirection planeDirection = PlaneDirection.NONE;


        if (x - 5 > planeController2.getGameObject().getX()) planeDirection = PlaneDirection.RIGHT;
        else if (x + 5 < planeController2.getGameObject().getX()) planeDirection = PlaneDirection.LEFT;
        else planeDirection = PlaneDirection.STOP_X;
        return planeDirection;

    }

    public PlaneDirection planeDirection2(int y){
        PlaneDirection planeDirection = PlaneDirection.NONE;

        if (y - 5 > planeController2.getGameObject().getY()) planeDirection = PlaneDirection.DOWN;
        else if (y + 5 < planeController2.getGameObject().getY()) planeDirection = PlaneDirection.UP;
        else planeDirection = PlaneDirection.STOP_Y;
        return planeDirection;
    }


    public void check(EnemyController enemyController){
        int x;
        for (int i = 0; i < bulletControllerVector.size(); i++) {
            if (bulletControllerVector.get(i).getGameObject().getY() < 0 ) {
                bulletControllerVector.remove(i);
            }else
            if (bulletControllerVector.get(i).gameObject.getX() >= enemyController.gameObject.getX()
                    && bulletControllerVector.get(i).gameObject.getX() - enemyController.gameObject.getX() <= enemyController.gameObject.getWidth()
                    && bulletControllerVector.get(i).gameObject.getY() >= enemyController.gameObject.getY()
                    && bulletControllerVector.get(i).gameObject.getY() - enemyController.gameObject.getY() <= enemyController.gameObject.getHeight()) {
                enemyController.getGameObject().setY(20);
                bulletControllerVector.remove(i);
            }
        }
    }

}
