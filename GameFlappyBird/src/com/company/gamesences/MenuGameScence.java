package com.company.gamesences;

import com.company.Models.GameConfig;
import com.company.Models.Ground;
import com.company.Utils;

import java.awt.*;
import java.awt.event.KeyEvent;

//import vn.edu.techkids.Utils;
//import vn.edu.techkids.models.GameConfig;

/**
 * Created by qhuydtvt on 5/13/2016.
 */
public class MenuGameScence extends GameScence {
    public static boolean check = false;
    Image backgoundImage;
    Image ground;
    Image image;
    Image image1;
    Image bird;
    public MenuGameScence() {
        this.backgoundImage = Utils.loadImage("resources/background.png");
        this.image = Utils.loadImage("resources/MenuPlay.png");
        this.image1 = Utils.loadImage("resources/getready.png");
        this.ground = Utils.loadImage("resources/ground.png");
        this.bird = Utils.loadImage("resources/bird11.png");
    }

    @Override
    public void run() {

    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(this.backgoundImage, 0, 0,
                GameConfig.getInst().getScreenWidth(), GameConfig.getInst().getScreenHeight(), null);
        g.drawImage(this.image,25,275,300,150,null);
        g.drawImage(this.image1,50,50,300,150,null);

        g.drawImage(this.ground,0,600 - Ground.DEFAULT_GROUND_HEIGHT,Ground.DEFAULT_GROUND_WIDTH,Ground.DEFAULT_GROUND_HEIGHT,null);
        g.drawImage(this.bird,100,250,50,50,null);
    }

    @Override
    public void onKeyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE) {
            changeGameScene(GameScenceType.PLAY);
            check = true;
        }
    }

    @Override
    public void onKeyReleased(KeyEvent e) {

    }
}
