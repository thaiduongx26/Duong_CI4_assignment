package com.company.gamesences;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by qhuydtvt on 5/13/2016.
 */


public abstract class GameScence extends Frame{

    private GameSceneListener gameSceneListener;

    public void setGameSceneListener(GameSceneListener gameSceneListener) {
        this.gameSceneListener = gameSceneListener;
    }

    protected void changeGameScene(GameScenceType gameScenceType) {
        if(gameSceneListener != null) {
            gameSceneListener.changeGameScence(gameScenceType);
        }
        else {
            System.out.println("-------------------------null");
        }
    }

    public abstract void run();

    public abstract void paint(Graphics g);

    public abstract void onKeyPressed(KeyEvent e);

    public abstract void onKeyReleased(KeyEvent e);
}
