package vn.edu.techkids;
/* TODO packaage exanplation */

import vn.edu.techkids.controllers.EnemyController;
import vn.edu.techkids.controllers.PlaneController;
import vn.edu.techkids.controllers.PlaneDirection;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;

/**
 * Created by qhuydtvt on 4/24/2016.
 */
public class GameWindow extends Frame implements Runnable {
    Image backgroundImage;
    Thread thread;
    Image backbufferImage;
    PlaneController planeController1;

    PlaneController planeController2;

    Calendar calendar;

    EnemyController enemyController;

    public GameWindow () {
        this.setVisible(true);
        this.setSize(400, 600);

        this.planeController1 = PlaneController.getPlaneController1();

        this.planeController2 = PlaneController.getPlaneController2();

        this.enemyController = EnemyController.getEnemyController();

        try {
            backgroundImage = ImageIO.read(new File("resources/background.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                System.out.println("windowOpened");
            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("windowClosing");
                System.exit(0);

            }

            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("windowClosed");
            }

            @Override
            public void windowIconified(WindowEvent e) {
                System.out.println("windowIconified");
            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });

        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println("keyTyped");
            }

            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("keyPressed");
                System.out.println(e.getKeyCode());

                PlaneDirection planeDirection = PlaneDirection.NONE;

                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        planeDirection = PlaneDirection.UP;
                        break;
                    case KeyEvent.VK_DOWN:
                        planeDirection = PlaneDirection.DOWN;
                        break;
                    case KeyEvent.VK_LEFT:
                        planeDirection = PlaneDirection.LEFT;
                        break;
                    case KeyEvent.VK_RIGHT:
                        planeDirection = PlaneDirection.RIGHT;
                        break;
                    case KeyEvent.VK_SPACE:
                        planeController1.shot();
                        break;
                }

                planeController1.move(planeDirection);
                /*TODO static explanation*/
            }

            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println("keyReleased");

                PlaneDirection planeDirection = PlaneDirection.NONE;
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                    case KeyEvent.VK_DOWN:
                        planeDirection = PlaneDirection.STOP_Y;
                        break;
                    case KeyEvent.VK_LEFT:
                    case KeyEvent.VK_RIGHT:
                        planeDirection = PlaneDirection.STOP_X;
                        break;
                }
                planeController1.move(planeDirection);
            }
        });
        this.addMouseMotionListener(new MouseMotionListener(){

            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {
//                dx2 = e.getX();
//                dy2 = e.getY();
//x2 => e.getX(); y2 => e.getY()

//                if(e.getX() - 5 > x2) {
//                    dx2 = 5;
//                } else if(e.getX() +5 < x2) {
//                    dx2 = -5;
//                } else {
//                    dx2 = 0;
//                }
                System.out.println("mouseMoved");
            }
        });
        thread = new Thread(this);
        thread.start();

    }

    @Override
    public void update(Graphics g) {

        if(backbufferImage == null){
            backbufferImage =  new BufferedImage(400, 600, 1);
        }
        Graphics backbufferGraphics = backbufferImage.getGraphics();
        backbufferGraphics.drawImage(backgroundImage, 0, 0, null);
        planeController1.paint(backbufferGraphics);
        planeController2.paint(backbufferGraphics);
        enemyController.paint(backbufferGraphics);

        g.drawImage(backbufferImage, 0, 0, null);
    }

    @Override
    public void run() {
        long count = 0;

        while(true){
//            count++;
//            System.out.println(count);

            try {

//                PlaneDirection planeDirection1 = PlaneDirection.NONE;
//                Point mousePoint = MouseInfo.getPointerInfo().getLocation();
//                mousePoint.x -= getLocationOnScreen().x;
//                mousePoint.y -= getLocationOnScreen().y;
//
//                if(mousePoint.x - 40 > planeController2.getGameObject().getX()) {
//                    planeDirection1 = PlaneDirection.RIGHT;
//                } else if(mousePoint.x -30 < planeController2.getGameObject().getX()) {
//                    planeDirection1 = PlaneDirection.LEFT;
//                } else {
//                    planeDirection1 = PlaneDirection.STOP_X;
//                }
//                planeController2.move(planeDirection1);
//
//                if(mousePoint.y - 35 > planeController2.getGameObject().getY()) {
//                    planeDirection1 = PlaneDirection.DOWN;
//                } else if(mousePoint.y - 25 < planeController2.getGameObject().getY()) {
//                    planeDirection1 = PlaneDirection.UP;
//                } else {
//                    planeDirection1 = PlaneDirection.STOP_Y;
//                }
//
//                planeController2.move(planeDirection1);
//
//                planeController2.run();

                planeController1.run();
                calendar = Calendar.getInstance();


                enemyController.run();

                repaint();


                Thread.sleep(17);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
