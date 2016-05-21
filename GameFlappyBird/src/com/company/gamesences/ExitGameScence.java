package com.company.gamesences;

import com.company.Controller.BirdController;
import com.company.Models.Score;
import com.company.Utils;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * Created by Wrong on 5/15/2016.
 */
public class ExitGameScence extends GameScence {
    Image exitBackground;
    Image scoreImage;
    Image highScore;
    Image endImage;
    private static boolean check = false;

    public static boolean isCheck() {
        return check;
    }

    public static void setCheck(boolean check) {
        ExitGameScence.check = check;
    }

    public ExitGameScence() {
        this.exitBackground = Utils.loadImage("resources/background.png");
        this.endImage = Utils.loadImage("resources/press_R.png");
        this.highScore = Utils.loadImage("resources/high_score_1.png");
        this.scoreImage = Utils.loadImage("resources/high_score_2.png");
    }


    @Override
    public void run() {

    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(this.exitBackground, 0, 0,
                400, 600, null);
//        if (Score.score > Score.highScore) {
//            Score.highScore = Score.score;
        g.drawImage(this.endImage, 20, 50, 350, 250, null);
            g.setFont(new Font("Segoe UI Black", Font.PLAIN, 50));
            g.drawString(String.valueOf(Score.score), 190, 300);
//        }
    }

    @Override
    public void onKeyPressed(KeyEvent e) {
//        System.out.println("123");
        if(e.getKeyCode() == KeyEvent.VK_R) {
//            System.out.println(1);
//            BirdController.getBirdController().getGameObject().setAlive(true);
//            BirdController.getBirdController().getGameObject().setX(100);
//            BirdController.getBirdController().getGameObject().setY(200);
//            ChimneyControllerManager.cout = 400;
//            PlayGameScence.getInst().reset();
            changeGameScene(GameScenceType.RESTART);
            Score.score = 0;
//            ExitGameScence.setCheck(true);
//            System.out.println(BirdController.getBirdController().getGameObject().getX());

//            changeGameScene(GameScenceType.MENU);
        }
    }

    @Override
    public void onKeyReleased(KeyEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }
}
