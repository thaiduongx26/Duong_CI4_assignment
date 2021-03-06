package com.company.gamesences;

import com.company.Controller.*;
import com.company.Controller.ButterflyController;
import com.company.Controller.enemycontroller.ChimneyController;
import com.company.Controller.enemycontroller.ChimneyControllerManager;
import com.company.Models.*;
import com.company.Utils;
import com.company.View.AnimationDrawer;
import com.company.View.ImageDrawer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

/**
 * Created by qhuydtvt on 5/13/2016.
 */
public class PlayGameScence extends GameScence {
    private int count_score = 1;
    private int countScore = 0;
    private Image backgroundImage;
    private BirdController birdController;
    private BirdController birdController2;
    private Vector<Controller> controllerVect;
    private GameConfig gameConfig;
    private GroundController groundController;
    private ChimneyControllerManager chimneyControllerManager;
    private ButterflyController butterflyController;
    private Butterfly buterfly;
    private Gift gift;
    private GiftController giftController;
    private ImageDrawer imageDrawer;
    public static boolean checkButterfly = false;
    private int count = 0;
    private int width_bird_1 = 50;
    private int height_bird_1 = 50;
    private int width_bird_2 = 50;
    private int height_bird_2 = 50;


    private boolean testChange = false;

//    private BirdController birdController;

    public static boolean checkDeleteChimney = false;

    public static boolean checkReset = false;
    AnimationDrawer birdNormal;
    Bird bird;
    private int count1 = 0;
    public static boolean check1 = true;
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
        checkButterfly = false;
        gameConfig = GameConfig.getInst();
        buterfly = new Butterfly(400, 200, 40, 40);
        imageDrawer = new ImageDrawer("resources/Butterfly.png");
        butterflyController = new ButterflyController(buterfly, imageDrawer);
        controllerVect = new Vector<Controller>();
//        PlayGameScence.getInst().reset();
        bird = new Bird(100, 250, 50, 50);
        birdNormal = new AnimationDrawer(
                new String[]{
                        "resources/bird11.png",
                        "resources/bird12.png",
                        "resources/bird13.png",
                }
        );
        birdController = new BirdController(bird, birdNormal);

        bird = new Bird(20,250,50,50);
        birdNormal = new AnimationDrawer(
                new String[]{
                        "resources/bird11.png",
                        "resources/bird12.png",
                        "resources/bird13.png",
                }
        );
        birdController2 = new BirdController(bird,birdNormal);
//        this.birdController = BirdController.getBirdController();
//        controllerVect.add(birdController);
//        controllerVect.add(new BombControllerManager());
        chimneyControllerManager = new ChimneyControllerManager();
        chimneyControllerManager.reset();
//        controllerVect.add(chimneyControllerManager);


        this.groundController = GroundController.getGroundController();
//        if(GiftController.check ==1){
            gift = new Gift(400, 300, 40, 40);
            imageDrawer = new ImageDrawer("resources/gift2.png");
            giftController = new GiftController(gift, imageDrawer);
//        }
        Gift gift = new Gift(400, 300 , Gift.WIDTH_GIFT,Gift.HEIGHT_GIFT);
        ImageDrawer imageDrawer = new ImageDrawer("resources/gift.jpg");
        GiftController giftController = new GiftController(gift,imageDrawer);

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

    public void reset() {
        checkDeleteChimney = true;
    }

    @Override
    public void run() {
        CollisionPool.getInst().run();
        check1 = true;
        if (birdController.getGameObject().isAlive() ) {
            birdController.run();
//            birdController2.run();
//            for (Controller controller : controllerVect) {
//                controller.run();
////                System.out.println("xxx");
//            }
            butterflyController.run();
            chimneyControllerManager.run();
            giftController.run();
            if (Score.score % 5 != 0) {
                count_score = 0;
            }

            if (Score.score % 5 == 0 && Score.score != 0 && count_score == 0) {
                count_score = 1;
                ChimneyController.addSpeed();
//                ImageDrawer imageDrawer = new ImageDrawer("resources/gift.jpg");
//                GiftController giftController = new GiftController(gift,imageDrawer);
            }

            if (checkButterfly == true) {
                count++;
                if (testChange == false) {

                    changeBird1();

                    testChange = true;
//                    butterflyController.getGameObject().setAlive(false);
                }
                if (GameConfig.getInst().durationInSeconds(count) >= 3 || check1 == false) {
                    count = 0;

                    checkButterfly = false;
                    defaultBird1();
                    testChange = false;

                }
//                SingleController.setIsPause(true);
            }else {
                defaultBird1();
            }
        } else {
//            this.reset();
            changeGameScene(GameScenceType.EXIT);
//            defaultBird1();
            Utils.playSound("resources/hit.wav", false);
//            checkReset = true;
//            PlayGameScence.getInst().reset();
        }

        count1 ++;
        if ((GameConfig.getInst().durationInSeconds(count1) >= 5 && Enemy.DEFAULT_AREA_BETWEEN_CHIMNEY ==250)|| !birdController.getGameObject().isAlive()){
            count1 = 0;
            Enemy.DEFAULT_AREA_BETWEEN_CHIMNEY = 150;
        }

    }


    public  void changeBird1() {
        width_bird_1 = (int) (width_bird_1 * 1.2);
        height_bird_1 = (int) (height_bird_1 * 1.2);
//        birdController.getGameObject().setWidth(width_bird_1);
//        birdController.getGameObject().setHeight(height_bird_1);
    }
//    public  void changeBird2() {
//        width_bird_2 = (int) (width_bird_2 * 1.2);
//        height_bird_2 = (int) (height_bird_2 * 1.2);
////        birdController.getGameObject().setWidth(width_bird_1);
////        birdController.getGameObject().setHeight(height_bird_1);
//    }
    public void defaultBird1() {
        width_bird_1 = 50;
        height_bird_1 = 50;
//        birdController.getGameObject().setWidth(50);
//        birdController.getGameObject().setHeight(50);
    }
//    public void defaultBird2() {
//        width_bird_2 = 50;
//        height_bird_2 = 50;
////        birdController.getGameObject().setWidth(50);
////        birdController.getGameObject().setHeight(50);
//    }

    @Override
    public void paint(Graphics backbufferGraphics) {
        backbufferGraphics.drawImage(backgroundImage, 0, 0,
                gameConfig.getScreenWidth(), gameConfig.getScreenHeight(), null);

//        for (Controller controller : controllerVect) {
//            controller.paint(backbufferGraphics);
//        }

        chimneyControllerManager.paint(backbufferGraphics);
        butterflyController.paint(backbufferGraphics);
        birdController.paint(backbufferGraphics);
//        if (GiftController.check == 1)
        giftController.paint(backbufferGraphics);
//        birdController2.paint(backbufferGraphics);
        groundController.paint(backbufferGraphics);
        backbufferGraphics.setFont(new Font("Segoe UI Black", Font.PLAIN, 30));
        backbufferGraphics.drawString("Score :" + Score.score, 50, 100);
    }

    @Override
    public void onKeyPressed(KeyEvent e) {

        BirdDirection birdDirection = BirdDirection.NONE;

        switch (e.getKeyCode()) {
            case KeyEvent.VK_SPACE:
                birdDirection = BirdDirection.SPACE;
                bird = new Bird(birdController.getGameObject().getX(), birdController.getGameObject().getY(), width_bird_1, height_bird_1);
                birdNormal = new AnimationDrawer(
                        new String[]{
                                "resources/bird51.png",
                                "resources/bird52.png",
                                "resources/bird53.png",
                        }
                );
                birdController = new BirdController(bird, birdNormal);
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
        bird = new Bird(birdController.getGameObject().getX(), birdController.getGameObject().getY(), width_bird_1, height_bird_1);

        birdNormal = new AnimationDrawer(
                new String[]{
                        "resources/bird41.png",
                        "resources/bird42.png",
                        "resources/bird43.png",
                }
        );

        birdController = new BirdController(bird, birdNormal);


        birdController.move(birdDirection);
    }

    @Override
    public void mousePressed(MouseEvent e) {
//        BirdDirection birdDirection = BirdDirection.SPACE;
//        bird = new Bird(birdController2.getGameObject().getX(), birdController2.getGameObject().getY(), width_bird_2, height_bird_2);
//        birdNormal = new AnimationDrawer(
//                new String[]{
//                        "resources/bird51.png",
//                        "resources/bird52.png",
//                        "resources/bird53.png",
//                }
//        );
//        birdController2 = new BirdController(bird, birdNormal);
//        birdController2.move(birdDirection);
//    }
//
//    @Override
//    public void mouseReleased(MouseEvent e) {
//        BirdDirection birdDirection = BirdDirection.NONE;
//        bird = new Bird(birdController2.getGameObject().getX(), birdController2.getGameObject().getY(), width_bird_2, height_bird_2);
//
//        birdNormal = new AnimationDrawer(
//                new String[]{
//                        "resources/bird41.png",
//                        "resources/bird42.png",
//                        "resources/bird43.png",
//                }
//        );
//
//        birdController2 = new BirdController(bird, birdNormal);
//
//
//        birdController2.move(birdDirection);
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }


    private static PlayGameScence inst;


    public static PlayGameScence getInst() {
        if (inst == null) {
            inst = new PlayGameScence();
        }
        return inst;
    }
}
