package com.company.gamescenes;

import com.company.Models.GameConfig;
import com.company.Utils;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Wrong on 5/15/2016.
 */
public class ExitGameScence extends GameScence {
    Image exitBackground;

    public ExitGameScence() {
        this.exitBackground = Utils.loadImage("resources/background.png");
    }


    @Override
    public void run() {

    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(this.exitBackground, 0, 0,
                GameConfig.getInst().getScreenWidth(), GameConfig.getInst().getScreenHeight(), null);
    }

    @Override
    public void onKeyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER) {
            changeGameScene(GameScenceType.PLAY);
        }
    }

    @Override
    public void onKeyReleased(KeyEvent e) {

    }
}
