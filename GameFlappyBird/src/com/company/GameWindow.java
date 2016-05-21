package com.company;
/* TODO packaage exanplation */

import com.company.Controller.BirdController;
import com.company.Controller.CollisionPool;
import com.company.Controller.enemycontroller.ChimneyController;
import com.company.Controller.enemycontroller.ChimneyControllerManager;
import com.company.Models.GameConfig;
import com.company.Models.Score;
import com.company.gamesences.*;
import com.company.gamesences.ExitGameScence;
import com.company.gamesences.GameScenceType;
import com.company.gamesences.PlayGameScence;
//import vn.edu.techkids.gamescenes.*;
//import vn.edu.techkids.models.GameConfig;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.Iterator;

/**
 * Created by qhuydtvt on 4/24/2016.
 */
public class GameWindow extends Frame implements Runnable, GameSceneListener {
    Thread thread;
    Image backbufferImage;
    GameConfig gameConfig;

    GameScence gameScence;

    public GameWindow() {

        this.gameConfig = GameConfig.getInst();
        gameScence = new MenuGameScence();
        gameScence.setGameSceneListener(this);
        this.setVisible(true);
        this.setSize(gameConfig.getScreenWidth(),
                gameConfig.getScreenHeight());



        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

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

            }

            @Override
            public void keyPressed(KeyEvent e) {
                gameScence.onKeyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                gameScence.onKeyReleased(e);
            }
        });

        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                gameScence.mousePressed(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                gameScence.mouseReleased(e);
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

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
            }
        });
        thread = new Thread(this);
        thread.start();

    }

    @Override
    public void update(Graphics g) {
        if(backbufferImage==null){
            backbufferImage = new BufferedImage(GameConfig.DEFAULT_SCREEN_WIDTH,GameConfig.DEFAULT_SCREEN_HEIGHT ,1);
        }

        Graphics backbufferGraphics = backbufferImage.getGraphics();
        gameScence.paint(backbufferGraphics);
        g.drawImage(backbufferImage,0,0,null);


    }

    @Override
    public void run() {
        long count = 0;

        while(true){
//            count++;
            try {

                Point mousePoint = MouseInfo.getPointerInfo().getLocation();

                mousePoint.x -= getLocationOnScreen().x;
                mousePoint.y -= getLocationOnScreen().y;

                /* TODO player2 moving */
//                if(mousePoint.x - 5 > plane2.x) {
//                    plane2.dx = 5;
//                } else if(mousePoint.x + 5 < plane2.x) {
//                    plane2.dx = -5;
//                } else {
//                    plane2.dx = 0;
//                }
//
//                if(mousePoint.y - 5 > plane2.y) {
//                    plane2.dy = 5;
//                } else if(mousePoint.y + 5 < plane2.y) {
//                    plane2.dy = -5;
//                } else {
//                    plane2.dy = 0;
//                }
                //               plane2.run();


                gameScence.run();

//                if (!BirdController.getBirdController().getGameObject().isAlive()){
//                    gameScence = new ExitGameScence();
//                }
////
////
//                if (ExitGameScence.isCheck() && gameScence instanceof ExitGameScence){
//                    ExitGameScence.setCheck(false);
//                    PlayGameScence.getInst().reset();
//                    gameScence = new PlayGameScence();
//
////                    gameScence.run();
//                }

//                if(gameScence instanceof MenuGameScence && MenuGameScence.check == true){
//                    gameScence = new PlayGameScence();
//                }

//                if (ExitGameScence.isCheck() && gameScence instanceof ExitGameScence){
////                    ChimneyControllerManager.getInst().setTmp(0);
////                    PlayGameScence.getInst().reset();
//                    gameScence = new PlayGameScence();
//
////                    PlayGameScence.getInst().again();
//                    ExitGameScence.setCheck(false);
//                    Score.score = 0;
//                    gameScence.run();
//                }
//                CollisionPool.getInst().run();

//                planeController1.run();
//                EnemyBulletControllerManager.getInst().run();
//                EnemyPlaneControllerManager.getInst().run();


                repaint();


                Thread.sleep(gameConfig.getThreadDelay());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void changeGameScence(GameScenceType gameScenceType) {
        switch (gameScenceType) {
            case MENU:
                gameScence = new MenuGameScence();
                gameScence.setGameSceneListener(this);
                break;
            case PLAY:
                gameScence = new PlayGameScence();
                gameScence.setGameSceneListener(this);
                break;
            case EXIT :
                gameScence = new ExitGameScence();
                gameScence.setGameSceneListener(this);
                break;
            case RESTART:
//                gameScence = null;
//                PlayGameScence.getInst().reset();
                gameScence = new MenuGameScence();
                gameScence.setGameSceneListener(this);
                break;
        }
    }

}
