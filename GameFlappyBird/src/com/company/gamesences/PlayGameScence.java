package com.company.gamesences;

import com.company.Controller.*;
import com.company.Controller.enemycontroller.ChimneyControllerManager;
import com.company.Models.GameConfig;
import com.company.Models.Score;

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

    public static boolean checkDeleteChimney = false;

//    public static boolean isCheck() {
//        return check;
//    }
//
//    public static void setCheck(boolean check) {
//        PlayGameScence.check = check;
//    }

    public PlayGameScence() {
      //  PlayGameScence.setCheck(true);
        System.out.println("dang o Play ");
        gameConfig = GameConfig.getInst();
        controllerVect = new Vector<Controller>();
//        PlayGameScence.getInst().reset();
        controllerVect.add(BirdController.getBirdController());
//        controllerVect.add(new BombControllerManager());
        chimneyControllerManager = new ChimneyControllerManager();
        controllerVect.add(chimneyControllerManager);
        this.birdController = BirdController.getBirdController();
        this.groundController = GroundController.getGroundController();

        try {
            backgroundImage = ImageIO.read(new File("resources/background.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void reset(){
        Iterator<Controller> iterator= controllerVect.iterator();
        while (iterator.hasNext()){
            Controller c = iterator.next();
            iterator.remove();
        }
        checkDeleteChimney = true;
    }

    @Override
    public void run() {
        CollisionPool.getInst().run();
        if (BirdController.getBirdController().getGameObject().isAlive())
            for (Controller controller: controllerVect){
                controller.run();
                System.out.println("xxx");
            }
        else {
            this.reset();
            changeGameScene(GameScenceType.EXIT);
//            PlayGameScence.getInst().reset();
        }

    }





    @Override
    public void paint(Graphics backbufferGraphics) {
        backbufferGraphics.drawImage(backgroundImage, 0, 0,
                gameConfig.getScreenWidth(), gameConfig.getScreenHeight(), null);

        for (Controller controller : controllerVect) {
            controller.paint(backbufferGraphics);
        }
        groundController.paint(backbufferGraphics);
        backbufferGraphics.setFont(new Font("Segoe UI Black",Font.PLAIN,30));
        backbufferGraphics.drawString("Score :"+ Score.score,50,100);
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
