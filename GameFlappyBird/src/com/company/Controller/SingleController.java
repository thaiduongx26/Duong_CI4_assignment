package com.company.Controller;

import com.company.Models.GameObject;
import com.company.Models.GameVector;
import com.company.View.GameDrawer;

import java.awt.*;

/**
 * Created by qhuydtvt on 4/29/2016.
 */
public class SingleController implements Controller {

    protected GameObject gameObject;
    protected GameDrawer gameDrawer;
    protected GameVector gameVector;
    protected static boolean isPause = false ;

    public SingleController(GameObject gameObject, GameDrawer gameDrawer) {
        this.gameObject = gameObject;
        this.gameDrawer = gameDrawer;
        this.gameVector = new GameVector();
    }

    public static boolean isPause() {
        return isPause;
    }

    public static void setIsPause(boolean isPause) {
        SingleController.isPause = isPause;
    }

    @Override
    public void run() {
        if (!isPause) {
            gameObject.move(gameVector);
        }
    }

    public GameObject getGameObject() {
        return gameObject;
    }

    @Override
    public void paint(Graphics g) {
        gameDrawer.paint(this.gameObject, g);
    }
}
