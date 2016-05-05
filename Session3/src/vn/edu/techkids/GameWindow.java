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
import java.util.Vector;

/**
 * Created by qhuydtvt on 4/24/2016.
 */
public class GameWindow extends Frame implements Runnable {
    Image backgroundImage;
    Thread thread;
    Image backbufferImage;
    PlaneController planeController1;

    PlaneController planeController2;

    PlaneDirection planeDirection2 = PlaneDirection.NONE;
    PlaneDirection planeDirection3 = PlaneDirection.NONE;


    Calendar calendar;
//    EnemyController enemyController1;
//    EnemyController enemyController2 ;
//    EnemyController enemyController3 ;

    EnemyController enemyController;
//    Vector<EnemyController> enemyControllerVector;
//
//    EnemyController[] enemyControllers;

    public GameWindow () {
        this.setVisible(true);
        this.setSize(400, 600);

//        enemyControllerVector = new Vector<EnemyController>();

//        enemyControllers = new EnemyController[2];
//        enemyController1 = EnemyController.getEnemyController(20);
//        enemyControllerVector.add(enemyController1);
//


//        enemyController2.getEnemyController(enemyController2,20);
//
//        enemyController3.getEnemyController(enemyController3,300);



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
                planeController2.setxOfMouse(e.getXOnScreen());
                planeController2.setyOfMouse(e.getYOnScreen());
                System.out.println("mouseMoved");
            }
        });
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                planeController2.shot();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

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
        planeController2.paint(backbufferGraphics);
        planeController1.paint(backbufferGraphics);

//        for (EnemyController enemyController1:enemyControllers){
//            enemyController1.paint(backbufferGraphics);
//        }
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

                enemyController.run();

                planeController1.run();
                planeDirection2 = planeController2.planeDirection1(planeController2.getxOfMouse());

                planeDirection3 = planeController2.planeDirection2(planeController2.getyOfMouse());
                planeController2.move(planeDirection2);
                planeController2.move(planeDirection3);
                planeController2.run();
                planeController1.check(enemyController);
                planeController2.check(enemyController);


                repaint();

                Thread.sleep(17);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
