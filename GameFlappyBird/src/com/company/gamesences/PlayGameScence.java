package com.company.gamesences;

import com.company.Controller.*;
import com.company.Controller.enemycontroller.ChimneyControllerManager;
import com.company.Models.Bird;
import com.company.Models.GameConfig;
import com.company.Models.Score;
import com.company.View.AnimationDrawer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Vector;

/**
 * Created by qhuydtvt on 5/13/2016.
 */
public class PlayGameScence extends GameScence {
    private int countScore = 0;
    private Image backgroundImage;
    private BirdController birdController;
    private Vector<Controller> controllerVect;
    private GameConfig gameConfig;
    private GroundController groundController;
    private ChimneyControllerManager chimneyControllerManager;
//    private BirdController birdController;

    public static boolean checkDeleteChimney = false;

    public static boolean checkReset = false;

//    public static boolean isCheck() {
//        return check;
//    }
//
//    public static void setCheck(boolean check) {
//        PlayGameScence.check = check;
//    }

    public PlayGameScence() {
      //  PlayGameScence.setCheck(true);
//        System.out.println("dang o Play ");
        gameConfig = GameConfig.getInst();
        controllerVect = new Vector<Controller>();
//        PlayGameScence.getInst().reset();
        Bird bird = new Bird(100, 250, 50, 50);
        AnimationDrawer birdNormal = new AnimationDrawer(
                new String[] {
                        "resources/bird11.png",
                        "resources/bird12.png",
                        "resources/bird13.png",
                }
        );
        birdController = new BirdController(bird, birdNormal);
//        controllerVect.add(birdController);
//        controllerVect.add(new BombControllerManager());
        chimneyControllerManager = new ChimneyControllerManager();
        chimneyControllerManager.reset();
//        controllerVect.add(chimneyControllerManager);
//        this.birdController = BirdController.getBirdController();
        this.groundController = GroundController.getGroundController();

        try {
            backgroundImage = ImageIO.read(new File("resources/background.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public void reset(){
//        Iterator<Controller> iterator= controllerVect.iterator();
//        while (iterator.hasNext()){
//            Controller c = iterator.next();
//            iterator.remove();
//        }
//        checkDeleteChimney = true;
//    }

    public void reset(){
        checkDeleteChimney = true;
    }

    @Override
    public void run() {
        CollisionPool.getInst().run();

        if (birdController.getGameObject().isAlive()) {
            birdController.run();
//            for (Controller controller : controllerVect) {
//                controller.run();
////                System.out.println("xxx");
//            }
            chimneyControllerManager.run();

        }
        else {
//            this.reset();
            changeGameScene(GameScenceType.EXIT);
//            checkReset = true;
//            PlayGameScence.getInst().reset();
        }


    }





    @Override
    public void paint(Graphics backbufferGraphics) {
        backbufferGraphics.drawImage(backgroundImage, 0, 0,
                gameConfig.getScreenWidth(), gameConfig.getScreenHeight(), null);

//        for (Controller controller : controllerVect) {
//            controller.paint(backbufferGraphics);
//        }
        chimneyControllerManager.paint(backbufferGraphics);
        birdController.paint(backbufferGraphics);
        groundController.paint(backbufferGraphics);
        backbufferGraphics.setFont(new Font("Segoe UI Black",Font.PLAIN,30));
//        backbufferGraphics.drawString("Score :"+ Score.score,50,100);
    }

    @Override
    public void onKeyPressed(KeyEvent e) {

        BirdDirection birdDirection = BirdDirection.NONE;

        switch (e.getKeyCode()) {
            case KeyEvent.VK_SPACE:
                birdDirection = BirdDirection.SPACE;
                break;
            case KeyEvent.VK_P:
                SingleController.setIsPause(true);
                break;
            case KeyEvent.VK_R:
                SingleController.setIsPause(false);
                break;
        }

        birdController.move(birdDirection);
    }

    @Override
    public void onKeyReleased(KeyEvent e) {
        BirdDirection birdDirection = BirdDirection.NONE;
        birdController.move(birdDirection);
    }


    private static PlayGameScence inst;



    public static PlayGameScence getInst(){
        if (inst == null){
            inst = new PlayGameScence();
        }
        return inst;
    }
}
