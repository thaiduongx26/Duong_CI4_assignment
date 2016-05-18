package com.company.gamescenes;

import com.company.Controller.BirdController;
import com.company.Controller.enemycontroller.ChimneyController;
import com.company.Controller.enemycontroller.ChimneyControllerManager;
import com.company.Models.Bird;
import com.company.Models.GameConfig;
import com.company.Utils;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Wrong on 5/15/2016.
 */
public class ExitGameScence extends GameScence {
    Image exitBackground;
    private static boolean check = false;

    public static boolean isCheck() {
        return check;
    }

    public static void setCheck(boolean check) {
        ExitGameScence.check = check;
    }

    public ExitGameScence() {
        this.exitBackground = Utils.loadImage("resources/gameover.png");
    }


    @Override
    public void run() {

    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(this.exitBackground, 50, 100,
                300, 175, null);
    }

    @Override
    public void onKeyPressed(KeyEvent e) {
//        System.out.println("123");
        if(e.getKeyCode() == KeyEvent.VK_E) {
            System.out.println(1);
            BirdController.getBirdController().getGameObject().setAlive(true);
            BirdController.getBirdController().getGameObject().setX(100);
            BirdController.getBirdController().getGameObject().setY(200);
//            ChimneyControllerManager.cout = 400;

            ExitGameScence.setCheck(true);
//            System.out.println(BirdController.getBirdController().getGameObject().getX());
        }
    }

    @Override
    public void onKeyReleased(KeyEvent e) {

    }
}
